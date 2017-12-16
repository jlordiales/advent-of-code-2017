package me.jlordiales.aoc2017.day3

import spock.lang.Specification
import spock.lang.Unroll

import static me.jlordiales.aoc2017.Day3.Day3.distanceFromCellWithNumber
import static me.jlordiales.aoc2017.Day3.Day3.firstValueWrittenBiggerThan

class Day3Test extends Specification {

    @Unroll
    def "distance 1"() {
        expect:
        distanceFromCellWithNumber(number) == distance

        where:
        number || distance
        1      || 0
        12     || 3
        23     || 2
        1024   || 31
    }

    @Unroll
    def "distance 2"() {
        expect:
        firstValueWrittenBiggerThan(input) == result

        where:
        input  || result
        1      || 2
        5      || 10
        26     || 54
        780    || 806
        265149 || 266330
    }
}
