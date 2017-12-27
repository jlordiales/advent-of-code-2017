package me.jlordiales.aoc2017.Day25

import spock.lang.Specification


class InstructionTest extends Specification {

    def "from input"() {
        given:
        def input = """- Write the value 1.
                       - Move one slot to the right.
                       - Continue with state B."""

        when:
        def instruction = Instruction.fromInput(input)

        then:
        instruction.newPosition(0) == 1
        instruction.valueToWrite == 1
        instruction.nextState == "B"
    }
}
