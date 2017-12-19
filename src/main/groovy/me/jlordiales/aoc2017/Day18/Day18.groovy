package me.jlordiales.aoc2017.Day18

class Day18 {

    static def runPrograms(String input) {
        def lines = input.readLines().collect {it.trim()}

        def program0 = new Program(instructions: lines, programId: 0)
        def thread0 = new Thread(program0)
        def program1 = new Program(instructions: lines, programId: 1, otherProgram: program0)
        program0.otherProgram = program1
        def thread1 = new Thread(program1)

        thread0.start()
        thread1.start()

        def threadList = [thread0, thread1]
        while (threadList.any {it.state == Thread.State.RUNNABLE}) {
            Thread.sleep(1000)
        }
        program1.numberOfSends
    }
}
