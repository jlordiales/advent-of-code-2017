package me.jlordiales.aoc2017.Day18

import groovy.transform.Canonical

import java.util.stream.Stream

@Canonical
class Instructions {
    def lastPlayedFrequency = -1
    int currentInstruction = 0
    List<String> instructions = []
    def registers = new Registers()

    int recoveredFrequency() {
        Stream.iterate(instructions[0], { processInstruction(it) })
              .filter({ isEffectiveRcv(it) })
              .findFirst()

        return lastPlayedFrequency
    }

    private def processInstruction(String instruction) {
        def instructionParts = instruction.tokenize(" ").collect { it.trim() }
        switch (instructionParts[0]) {
            case "snd":
                playSound(instructionParts[1])
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
                recover(instructionParts[1])
                break
            case "jgz":
                jump(instructionParts[1], instructionParts[2])
                break
        }
        instructions[currentInstruction]
    }

    private def jump(String value, String offset) {
        if (getValue(value) > 0) {
            currentInstruction += getValue(offset)
        } else {
            currentInstruction++
        }
    }

    private def recover(String value) {
        if (getValue(value) != 0) {
            return lastPlayedFrequency
        }
        currentInstruction++
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

    private def playSound(String frequency) {
        this.lastPlayedFrequency = getValue(frequency)
        currentInstruction++
    }

    private boolean isEffectiveRcv(String instruction) {
        def parts = instruction.tokenize(" ").collect { it.trim() }
        parts[0] == "rcv" && getValue(parts[1]) > 0
    }

    private long getValue(String value) {
        value.isNumber() ? value.toLong() : registers.getValue(value)
    }
}
