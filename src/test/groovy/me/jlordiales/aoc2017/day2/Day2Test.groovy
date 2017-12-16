package me.jlordiales.aoc2017.day2

import me.jlordiales.aoc2017.input.Input
import spock.lang.Specification

import static me.jlordiales.aoc2017.day2.Day2.rowReducerFirstHalf
import static me.jlordiales.aoc2017.day2.Day2.rowReducerSecondHalf


class Day2Test extends Specification {

    def "checksum first half"() {
        given:
        def matrix = [[5, 1, 9, 5],
                      [7, 5, 3],
                      [2, 4, 6, 8]]

        expect:
        Day2.checksum(matrix, rowReducerFirstHalf()) == 18
    }

    def "checksum for input first half"() {
        expect:
        Day2.checksum(Input.forDay(2), rowReducerFirstHalf()) == 45351
    }

    def "test second half"() {
        given:
        def matrix = [[5,9,2,8],
                      [9,4,7,3],
                      [3,8,6,5]]

        expect:
        Day2.checksum(matrix, rowReducerSecondHalf()) == 9
    }

    def "checksum for input second half"() {
        expect:
        Day2.checksum(Input.forDay(2), rowReducerSecondHalf()) == 275
    }
}
