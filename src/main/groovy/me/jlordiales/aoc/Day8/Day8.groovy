package me.jlordiales.aoc.Day8


class Day8 {

    static Registers processInstructions(String instructions) {
        Registers registers = new Registers()
        instructions.readLines().collect { Instruction.fromLine(it) }.each { it.applyTo(registers) }
        registers
    }
}
