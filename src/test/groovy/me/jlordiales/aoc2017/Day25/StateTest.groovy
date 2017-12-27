package me.jlordiales.aoc2017.Day25

import spock.lang.Specification


class StateTest extends Specification {

    def "from input"() {
        given:
        def input = """In state A:
                          If the current value is 0:
                            - Write the value 1.
                            - Move one slot to the right.
                            - Continue with state B.
                          If the current value is 1:
                            - Write the value 0.
                            - Move one slot to the left.
                            - Continue with state B."""

        when:
        def state = State.fromInput(input)

        then:
        state.name == "A"
        state.getInstructionForValue(0).nextState == "B"
        state.getInstructionForValue(0).valueToWrite == 1
        state.getInstructionForValue(1).nextState == "B"
        state.getInstructionForValue(1).valueToWrite == 0
    }
}
