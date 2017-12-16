package me.jlordiales.aoc2017.Day15

import spock.lang.Specification


class Day15Test extends Specification {

    def "test count"() {
        given:
        Generator a = new Generator(previousValue: 277, factor: 16807)
        Generator b = new Generator(previousValue: 349, factor: 48271)

        expect:
        Day15.count(a,b) == 592
    }

    def "test count2"() {
        given:
        Generator a = new Generator(previousValue: 277, factor: 16807)
        Generator b = new Generator(previousValue: 349, factor: 48271)

        expect:
        Day15.count2(a,b) == 320
    }
}
