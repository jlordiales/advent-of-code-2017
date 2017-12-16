package me.jlordiales.aoc2017.Day4

import me.jlordiales.aoc2017.input.Input
import spock.lang.Specification


class Day4Test extends Specification {

    def "isValid"() {
        expect:
        Day4.isValid("aa bb cc dd ee")
        !Day4.isValid("aa bb cc dd aa")
        Day4.isValid("aa bb cc dd aaa")
    }

    def "isValid2"() {
        Day4.isValid2("abcde fghij")
        Day4.isValid2("a ab abc abd abf abj")
        Day4.isValid2("iiii oiii ooii oooi oooo")
        !Day4.isValid2("abcde xyz ecdab")
        !Day4.isValid2("oiii ioii iioi iiio")
    }

    def "count1"() {
        expect:
        Day4.numberOfValidPassphrases(Input.forDay(4), Day4.firstHalfValidator()) == 383
    }

    def "count2"() {
        expect:
        Day4.numberOfValidPassphrases(Input.forDay(4), Day4.secondHalfValidator()) == 265
    }
}
