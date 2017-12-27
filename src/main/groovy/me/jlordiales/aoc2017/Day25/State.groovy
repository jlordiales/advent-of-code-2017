package me.jlordiales.aoc2017.Day25

import groovy.transform.Immutable


@Immutable
class State {
    String name
    Map<Integer, Instruction> instruction

    static State fromInput(String input) {
        def lines = input.readLines()

        fromLines(lines)
    }

    protected static fromLines(List<String> lines) {
        def name = lines[0].charAt(lines[0].size() - 2)
        def instruction0 = Instruction.fromLines(lines[2..4])
        def instruction1 = Instruction.fromLines(lines[6..8])

        new State(name: name, instruction: [0: instruction0, 1: instruction1])
    }

    def getInstructionForValue(int value) {
        instruction.get(value)
    }

    def applyTo(Tape tape) {
        def tapeValue = tape.currentValue()
        def instruction = instruction.get(tapeValue)
        instruction.applyTo(tape)
    }
}
