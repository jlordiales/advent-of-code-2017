package me.jlordiales.aoc2017.Day18

import me.jlordiales.aoc2017.input.Input
import spock.lang.Specification


class Day18Test extends Specification {

    def "test example"() {
        given:
        def input = """snd 1
                    snd 2
                    snd p
                    rcv a
                    rcv b
                    rcv c
                    rcv d"""

        expect:
        Day18.runPrograms(input) == 3
    }

    def "test input"() {
        expect:
        Day18.runPrograms(Input.forDay(18)) == 8001
    }
}
