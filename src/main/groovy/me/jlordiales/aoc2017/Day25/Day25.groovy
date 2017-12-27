package me.jlordiales.aoc2017.Day25


class Day25 {

    static diagnosticChecksum(String input) {
        def blueprint = Blueprint.fromInput(input)
        def tape = new Tape()
        def currentState = blueprint.startState

        blueprint.steps.times {
            currentState = blueprint.apply(currentState, tape)
        }

        tape.values.values().count {it == 1}
    }
}
