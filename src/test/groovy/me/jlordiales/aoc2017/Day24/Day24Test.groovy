package me.jlordiales.aoc2017.Day24

import me.jlordiales.aoc2017.input.Input
import spock.lang.Specification


class Day24Test extends Specification {

    def "strongest bridge example"() {
        expect:
        Day24.strongestBridge("""0/2
                2/2
                2/3
                3/4
                3/5
                0/1
                10/1
                9/10""") == 31
    }

    def "longest bridge example"() {
        expect:
        Day24.longestBridge("""0/2
                2/2
                2/3
                3/4
                3/5
                0/1
                10/1
                9/10""") == 19
    }

    def "strongest bridge input"() {
        expect:
        Day24.strongestBridge(Input.forDay(24)) == 1695
    }

    def "longest bridge input"() {
        expect:
        Day24.longestBridge(Input.forDay(24)) == 1673
    }
}
