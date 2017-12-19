package me.jlordiales.aoc2017.Day18

import static java.lang.Thread.State.RUNNABLE

class Day18 {

    static def runPrograms(String input) {
        def lines = input.readLines().collect { it.trim() }

        def program0 = new Program(instructions: lines, programId: 0)
        def program1 = new Program(instructions: lines, programId: 1)

        program0.otherProgram = program1
        program1.otherProgram = program0

        def threadList = [new Thread(program0), new Thread(program1)]

        threadList.each { it.start() }
        while (threadList.any { it.state == RUNNABLE }) {
            Thread.sleep(1000)
        }

        program1.numberOfSends
    }
}
