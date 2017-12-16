package me.jlordiales.aoc2017.Day7

class Day7 {
    static def findProgramAtBase(String input) {
        findProgramAtBase(ProgramInfo.fromLines(input.readLines()))
    }

    static def balanceDifference(String input) {
        def baseProgram = findProgramAtBase(input)
        balanceDifference(baseProgram)
    }

    static def findProgramAtBase(List<ProgramInfo> programs) {
        def referencedPrograms = programs.programsAbove.name.flatten()
        programs.find { !referencedPrograms.contains(it.name) }
    }

    static def balanceDifference(ProgramInfo baseProgram) {
        def weights = baseProgram.subtowersWeight() as Set
        def diff = weights.max() - weights.min()

        def unbalancedNode = findUnbalancedProgram(baseProgram)
        unbalancedNode.weight - diff
    }

    static ProgramInfo findUnbalancedProgram(ProgramInfo baseProgram) {
        def weightsByNumberOfOccurrences = baseProgram.subtowersWeight().countBy { it }
        def unbalancedWeight = weightsByNumberOfOccurrences.find { it.value == 1 }.key
        def nodeWithDifferentWeight = baseProgram.programsAbove.find { it.totalWeight() == unbalancedWeight }
        if (nodeWithDifferentWeight.isBalanced()) {
            return nodeWithDifferentWeight
        }
        findUnbalancedProgram(nodeWithDifferentWeight)
    }
}
