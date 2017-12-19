package me.jlordiales.aoc2017.Day18

import me.jlordiales.aoc2017.input.Input
import spock.lang.Specification


class InstructionsTest extends Specification {

    def "test example"() {
        given:
        def list = """set a 1
                    add a 2
                    mul a a
                    mod a 5
                    snd a
                    set a 0
                    rcv a
                    jgz a -1
                    set a 1
                    jgz a -2""".readLines().collect {it.trim()}

        def instructions = new Instructions(instructions: list)

        expect:
        instructions.recoveredFrequency() == 4
    }

    def "test input"() {
        given:
        def list = Input.forDay(18).readLines().collect {it.trim()}

        def instructions = new Instructions(instructions: list)

        expect:
        instructions.recoveredFrequency() == 7071
    }
}
