package me.jlordiales.aoc.Day5


class Day5 {

    static int numberOfStepsToExit1(List<Integer> instructions) {
        numberOfStepsToExit(instructions, { it + 1 })
    }

    static int numberOfStepsToExit2(List<Integer> instructions) {
        numberOfStepsToExit(instructions, { it >= 3 ? it - 1 : it + 1 })
    }

    static int numberOfStepsToExit(List<Integer> instructions, Closure<Integer> instructionModifier) {
        int currentIndex = 0
        int steps = 0
        while (currentIndex >= 0 && currentIndex < instructions.size()) {
            def nextIndex = currentIndex + instructions[currentIndex]
            instructions[currentIndex] = instructionModifier(instructions[currentIndex])
            currentIndex = nextIndex
            steps++
        }
        steps
    }

    static List<Integer> toInstructionList(String instructions) {
        instructions.readLines().collect { Integer.valueOf(it.trim()) }
    }
}
