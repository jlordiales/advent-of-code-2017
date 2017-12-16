package me.jlordiales.aoc.Day16

import me.jlordiales.aoc.input.Input
import spock.lang.Specification

class Day16Test extends Specification {

    def "test"() {
        expect:
        Day16.dance(['a', 'b', 'c', 'd', 'e'], "s1,x3/4,pe/b").join() == "baedc"
        Day16.dance(Input.forDay(16)) == "kbednhopmfcjilag"
    }

    def "test2"() {
        given:
        def input = Input.forDay(16)
        int cycleSize = Day16.cycleSize(input)

        expect:
        Day16.danceNTimes(input, 1000000000 % cycleSize) == "fbmcgdnjakpioelh"
    }
}
