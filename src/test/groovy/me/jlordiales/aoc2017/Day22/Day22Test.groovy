package me.jlordiales.aoc2017.Day22

import me.jlordiales.aoc2017.input.Input
import spock.lang.Specification


class Day22Test extends Specification {

    def 'test example'() {
        given:
        def input = """.........
                       .........
                       .........
                       .....#...
                       ...#.....
                       .........
                       .........
                       ........."""

        expect:
        Day22.solveFirstHalf(input) == 5587
        Day22.solveSecondHalf(input) == 2511944
    }

    def "test input"() {
        expect:
        Day22.solveFirstHalf(Input.forDay(22)) == 5460
        Day22.solveSecondHalf(Input.forDay(22)) == 2511702
    }
}
