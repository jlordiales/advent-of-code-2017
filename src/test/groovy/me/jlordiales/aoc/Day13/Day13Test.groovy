package me.jlordiales.aoc.Day13

import me.jlordiales.aoc.input.Input
import spock.lang.Specification


class Day13Test extends Specification {

    def "severity test"() {
        given:
        def input = """0: 3
                       1: 2
                       4: 4
                       6: 4"""

        expect:
        Day13.severityFor(input) == 24
    }

    def "delay test"() {
        given:
        def input = """0: 3
                       1: 2
                       4: 4
                       6: 4"""

        expect:
        Day13.minimumDelayToNotGetCaught(input) == 10
    }

    def "severity for input"() {
        expect:
        Day13.severityFor(Input.forDay(13)) == 1876
    }

    def "delay for input"() {
        expect:
        Day13.minimumDelayToNotGetCaught(Input.forDay(13)) == 3964778
    }
}
