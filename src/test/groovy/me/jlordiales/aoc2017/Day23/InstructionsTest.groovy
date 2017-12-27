package me.jlordiales.aoc2017.Day23

import me.jlordiales.aoc2017.input.Input
import spock.lang.Specification


class InstructionsTest extends Specification {

    def "solve input"() {
        given:
        def list = Input.forDay(23).readLines().collect { it.trim() }

        def instructions = new Instructions(instructions: list)

        expect:
        instructions.numberOf("mul") == 23
    }

    def "solve input 2"() {
        given:
        def registers = new Registers()
        registers.setValue("a", 1)
        def list = Input.forDay(23).readLines().collect { it.trim() }

        def instructions = new Instructions(instructions: list, registers: registers)

        expect:
        instructions.run().count() == 23
        registers.getValue('h') == 2
    }

    def "solve second half"() {
        expect:
        Instructions.solvePart2() == 915

    }
}
