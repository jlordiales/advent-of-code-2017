package me.jlordiales.aoc.Day5

import me.jlordiales.aoc.input.Input
import spock.lang.Specification


class Day5Test extends Specification {

    def "test1"() {
        expect:
        Day5.numberOfStepsToExit1([0, 3, 0, 1, -3]) == 5
    }

    def "test2"() {
        expect:
        Day5.numberOfStepsToExit2([0, 3, 0, 1, -3]) == 10
    }

    def "solve"() {
        given:
        def input = Input.forDay(5)

        def instructionList = Day5.toInstructionList(input)

        expect:
        Day5.numberOfStepsToExit1(new ArrayList<Integer>(instructionList)) == 374269
        Day5.numberOfStepsToExit2(new ArrayList<Integer>(instructionList)) == 27720699
    }
}
