package me.jlordiales.aoc2017.Day25

import me.jlordiales.aoc2017.input.Input
import spock.lang.Specification


class Day25Test extends Specification {

    def "checksum example"() {
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

        expect:
        Day25.diagnosticChecksum(input) == 3
    }

    def "checksum for input"() {
        expect:
        Day25.diagnosticChecksum(Input.forDay(25)) == 4769
    }
}
