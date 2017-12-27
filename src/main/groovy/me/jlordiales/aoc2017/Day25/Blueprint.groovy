package me.jlordiales.aoc2017.Day25

import groovy.transform.Immutable


@Immutable
class Blueprint {
    String startState
    int steps
    Map<String, State> states

    static Blueprint fromInput(String input) {
        def lines = input.readLines()
        def startState = lines[0].charAt(lines[0].size() - 2)
        def steps = Integer.valueOf(lines[1].tokenize()[5])
        def states = lines.drop(2).collate(10).collectEntries {
            def state = State.fromLines(it.drop(1))
            [state.name, state]
        }

        new Blueprint(startState: startState, steps: steps, states: states)
    }

    def apply(String stateName, Tape tape) {
        states.get(stateName).applyTo(tape)
    }
}
