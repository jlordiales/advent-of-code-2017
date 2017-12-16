package me.jlordiales.aoc2017.Day12

import me.jlordiales.aoc2017.input.Input
import spock.lang.Specification


class Day12Test extends Specification {

    def "groups for program"() {
        given:
        def input = """
                    0 <-> 2
                    1 <-> 1
                    2 <-> 0, 3, 4
                    3 <-> 2, 4
                    4 <-> 2, 3, 6
                    5 <-> 6
                    6 <-> 4, 5
                    """
        expect:
        Day12.groupForProgram(input, "0").size() == 6
    }

    def "all groups for program"() {
        given:
        def input = """
                    0 <-> 2
                    1 <-> 1
                    2 <-> 0, 3, 4
                    3 <-> 2, 4
                    4 <-> 2, 3, 6
                    5 <-> 6
                    6 <-> 4, 5
                    """
        expect:
        Day12.allGroups(input).size() == 2
    }

    def "groups for input"() {
        expect:
        Day12.groupForProgram(Input.forDay(12), "0").size() == 115
    }

    def "all groups for input"() {
        expect:
        Day12.allGroups(Input.forDay(12)).size() == 221
    }

}
