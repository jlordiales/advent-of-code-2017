package me.jlordiales.aoc2017.Day18

import groovy.transform.Canonical

import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue

@Canonical
class Program implements Runnable {
    long programId
    int currentInstruction = 0
    List<String> instructions = []
    def registers = new Registers()
    BlockingQueue<Long> queue = new LinkedBlockingQueue<>()
    Program otherProgram
    int numberOfSends = 0

    private def processInstruction(String instruction) {
        def instructionParts = instruction.tokenize(" ").collect {it.trim()}
        switch (instructionParts[0]) {
            case "snd":
                send(instructionParts[1])
                break
            case "set":
                set(instructionParts[1], instructionParts[2])
                break
            case "add":
                add(instructionParts[1], instructionParts[2])
                break
            case "mul":
                mul(instructionParts[1], instructionParts[2])
                break
            case "mod":
                mod(instructionParts[1], instructionParts[2])
                break
            case "rcv":
                receive(instructionParts[1])
                break
            case "jgz":
                jump(instructionParts[1], instructionParts[2])
                break
        }
    }

    def receive(String register) {
        long nextValueFromQueue = queue.take()
        registers.setValue(register, nextValueFromQueue)
        currentInstruction++
    }

    def send(String value) {
        otherProgram.putInQueue(getValue(value))
        currentInstruction++
        numberOfSends++
    }

    def putInQueue(long l) {
        queue.put(l)
    }

    private def jump(String value, String offset) {
        if (getValue(value) > 0) {
            currentInstruction += getValue(offset)
        } else {
            currentInstruction++
        }
    }

    private def set(String destinationRegistry, String value) {
        registers.setValue(destinationRegistry, getValue(value))
        currentInstruction++
    }

    private def add(String destinationRegistry, String value) {
        registers.computeValue(destinationRegistry, { it + getValue(value) })
        currentInstruction++
    }

    private def mul(String destinationRegistry, String value) {
        registers.computeValue(destinationRegistry, { it * getValue(value) })
        currentInstruction++
    }

    private def mod(String destinationRegistry, String value) {
        registers.computeValue(destinationRegistry, { it % getValue(value) })
        currentInstruction++
    }

    private long getValue(String value) {
        value.isNumber() ? value.toLong() : registers.getValue(value)
    }

    @Override
    void run() {
        registers.setValue("p", programId)
        while (currentInstruction >= 0 && currentInstruction < instructions.size()) {
            def nextInstruction = instructions[currentInstruction]
            processInstruction(nextInstruction)
        }
    }
}
