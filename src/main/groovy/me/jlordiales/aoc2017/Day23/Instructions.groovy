package me.jlordiales.aoc2017.Day23

import com.codepoetics.protonpack.StreamUtils
import groovy.transform.Canonical

import java.util.stream.Stream

@Canonical
class Instructions {
    int currentInstruction = 0
    List<String> instructions = []
    def registers = new Registers()

    int numberOf(String instruction) {
        run().filter({ it.startsWith(instruction) }).count()
    }

    static long solvePart2() {
        final int original = 57 * 100 + 100000
        (0..1000).count {
            int number = original + 17 * it
            !number.toBigInteger().isProbablePrime(100000)
        }
    }

    def run() {
        def instructionsStream = Stream.iterate(instructions[0], { processInstruction(it) })
        StreamUtils.takeUntil(instructionsStream, { it == null })
    }

    private def processInstruction(String instruction) {
        def instructionParts = instruction.tokenize(" ").collect { it.trim() }
        switch (instructionParts[0]) {
            case "set":
                set(instructionParts[1], instructionParts[2])
                break
            case "mul":
                mul(instructionParts[1], instructionParts[2])
                break
            case "sub":
                sub(instructionParts[1], instructionParts[2])
                break
            case "jnz":
                jump(instructionParts[1], instructionParts[2])
                break
        }
        (0..<instructions.size()).containsWithinBounds(currentInstruction) ? instructions[currentInstruction] : null
    }

    private def jump(String value, String offset) {
        if (getValue(value) != 0) {
            currentInstruction += getValue(offset)
        } else {
            currentInstruction++
        }
    }

    private def set(String destinationRegistry, String value) {
        registers.setValue(destinationRegistry, getValue(value))
        currentInstruction++
    }

    private def sub(String destinationRegistry, String value) {
        registers.computeValue(destinationRegistry, { it - getValue(value) })
        currentInstruction++
    }

    private def mul(String destinationRegistry, String value) {
        registers.computeValue(destinationRegistry, { it * getValue(value) })
        currentInstruction++
    }

    private long getValue(String value) {
        value.isNumber() ? value.toLong() : registers.getValue(value)
    }
}
