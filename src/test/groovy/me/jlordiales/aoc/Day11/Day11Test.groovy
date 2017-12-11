package me.jlordiales.aoc.Day11

import spock.lang.Specification
import spock.lang.Unroll

import static me.jlordiales.aoc.Day11.Day11.maxDistanceTraveled
import static me.jlordiales.aoc.Day11.Day11.numberOfSteps
import static me.jlordiales.aoc.input.Input.forDay

class Day11Test extends Specification {

    @Unroll
    def "test move"() {
        expect:
        numberOfSteps(directions) == distance

        where:
        directions       | distance
        "ne,ne,ne"       | 3
        "ne,ne,sw,sw"    | 0
        "ne,ne,s,s"      | 2
        "se,sw,se,sw,sw" | 3
        forDay(11)       | 743
    }

    @Unroll
    def "max distance traveled"() {
        expect:
        maxDistanceTraveled(directions) == distance

        where:
        directions       | distance
        "ne,ne,ne"       | 3
        "ne,ne,sw,sw"    | 2
        "ne,ne,s,s"      | 2
        "se,sw,se,sw,sw" | 3
        forDay(11)       | 1493
    }
}
