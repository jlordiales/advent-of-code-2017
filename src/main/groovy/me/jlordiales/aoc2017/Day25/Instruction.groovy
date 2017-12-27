package me.jlordiales.aoc2017.Day25

import groovy.transform.Immutable

@Immutable
class Instruction {
    int valueToWrite
    Closure<Integer> newPosition
    String nextState

    static Instruction fromInput(String input) {
        def lines = input.readLines()

        fromLines(lines)
    }

    protected static fromLines(List<String> lines) {
        def valueToWrite = lines[0].endsWith("1.") ? 1 : 0
        def newPosition = lines[1].endsWith("right.") ? { it + 1 } : { it - 1 }
        def nextState = lines[2].charAt(lines[2].size() - 2)

        new Instruction(valueToWrite: valueToWrite, newPosition: newPosition, nextState: nextState)
    }

    def applyTo(Tape tape) {
        tape.writeToCurrentPosition(valueToWrite)
        tape.setCurrentPosition(newPosition(tape.currentPosition))
        nextState
    }
}
