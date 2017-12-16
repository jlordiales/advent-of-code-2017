package me.jlordiales.aoc2017.day1

import me.jlordiales.aoc2017.input.Input
import spock.lang.Specification


class Day1Test extends Specification {

    def "test first half"() {
        expect:
        Day1.solve("1122", Day1.firstHalf()) == 3
        Day1.solve("1111", Day1.firstHalf()) == 4
        Day1.solve("1234", Day1.firstHalf()) == 0
        Day1.solve("91212129", Day1.firstHalf()) == 9
        Day1.solve(Input.forDay(1), Day1.firstHalf()) == 1390
    }

    def "test second half"() {
        expect:
        Day1.solve("1212", Day1.secondHalf()) == 6
        Day1.solve("1221", Day1.secondHalf()) == 0
        Day1.solve("123425", Day1.secondHalf()) == 4
        Day1.solve("123123", Day1.secondHalf()) == 12
        Day1.solve("12131415", Day1.secondHalf()) == 4
        Day1.solve(Input.forDay(1), Day1.secondHalf()) == 1232
    }
}
