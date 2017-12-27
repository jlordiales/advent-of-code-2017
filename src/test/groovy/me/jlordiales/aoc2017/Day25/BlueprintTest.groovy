package me.jlordiales.aoc2017.Day25

import spock.lang.Specification


class BlueprintTest extends Specification {

    def "from input"() {
        given:
        def input = """Begin in state A.
                        Perform a diagnostic checksum after 6 steps.
                        
                        In state A:
                          If the current value is 0:
                            - Write the value 1.
                            - Move one slot to the right.
                            - Continue with state B.
                          If the current value is 1:
                            - Write the value 0.
                            - Move one slot to the left.
                            - Continue with state B.
                        
                        In state B:
                          If the current value is 0:
                            - Write the value 1.
                            - Move one slot to the left.
                            - Continue with state A.
                          If the current value is 1:
                            - Write the value 1.
                            - Move one slot to the right.
                            - Continue with state A."""

        when:
        def blueprint = Blueprint.fromInput(input)

        then:
        blueprint.startState == "A"
        blueprint.steps == 6
        blueprint.states.get("A").getInstructionForValue(0).valueToWrite == 1
        blueprint.states.get("A").getInstructionForValue(1).valueToWrite == 0
        blueprint.states.get("B").getInstructionForValue(0).valueToWrite == 1
        blueprint.states.get("B").getInstructionForValue(1).valueToWrite == 1
    }
}
