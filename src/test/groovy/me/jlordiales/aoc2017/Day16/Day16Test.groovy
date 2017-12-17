package me.jlordiales.aoc2017.Day16

import me.jlordiales.aoc2017.input.Input
import spock.lang.Specification

class Day16Test extends Specification {

    def "test"() {
        expect:
        Day16.dance(Input.forDay(16)) == "kbednhopmfcjilag"
    }

    def "test2"() {
        expect:
        Day16.danceNTimes(Input.forDay(16), 1000000000) == "fbmcgdnjakpioelh"
    }
}
