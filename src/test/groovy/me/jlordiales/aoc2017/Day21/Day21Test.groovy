package me.jlordiales.aoc2017.Day21

import me.jlordiales.aoc2017.input.Input
import spock.lang.Specification


class Day21Test extends Specification {

    def "solve example"() {
        given:
        def input = """../.# => ##./#../...
                       .#./..#/### => #..#/..../..../#..#"""

        expect:
        Day21.solve(input, 2) == 12
    }

    def "solve for input"() {
        expect:
        Day21.solve(Input.forDay(21),5) == 173
        Day21.solve(Input.forDay(21),18) == 2456178
    }
}
