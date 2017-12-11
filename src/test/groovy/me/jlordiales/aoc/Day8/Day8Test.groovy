package me.jlordiales.aoc.Day8

import me.jlordiales.aoc.input.Input
import spock.lang.Specification


class Day8Test extends Specification {

    def "max value after processing instructions"() {
        given:
        def instructions = """b inc 5 if a > 1
                            a inc 1 if b < 5
                            c dec -10 if a >= 1
                            c inc -20 if c == 10"""

        expect:
        Day8.processInstructions(instructions).allValues().max() == 1
    }

    def "max value after processing input"() {
        given:
        def instructions = Input.forDay(8)
        expect:
        Day8.processInstructions(instructions).allValues().max() == 4416
    }

    def "highest value for input"() {
        given:
        def instructions = Input.forDay(8)
        expect:
        Day8.processInstructions(instructions).highestValueSoFar == 4416
    }

}
