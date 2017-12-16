package me.jlordiales.aoc2017.Day6

import spock.lang.Specification


class Day6Test extends Specification {

    def "test"() {
        expect:
        Day6.redistributionStates([0, 2, 7, 0]).size() == 5
        Day6.redistributionStates([1, 1, 1]).size() == 4
        Day6.redistributionStates([3, 1, 2]).size() == 3
        Day6.redistributionStates([4, 10, 4, 1, 8, 4, 9, 14, 5, 1, 14, 15, 0, 15, 3, 5]).size() == 12841
        Day6.redistributionStates([1, 0, 14, 14, 12, 11, 10, 9, 9, 7, 5, 5, 4, 3, 7, 1]).size() == 8038
    }
}
