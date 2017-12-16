package me.jlordiales.aoc2017.Day12


class Day12 {

    static def groupForProgram(String input, String program) {
        parseInput(input).groupForProgram(program)
    }

    static def allGroups(String input) {
        parseInput(input).allGroups()
    }

    static def parseInput(String input) {
        def programs = new Programs()
        input.readLines().each { parseInput(it, programs) }
        programs
    }

    static def parseInput(String line, Programs programs) {
        def matcher = line.trim() =~ /(\d*) <-> (.*)/
        if (matcher.matches()) {
            String origin = matcher[0][1].trim()
            Set<String> destinations = matcher[0][2].tokenize(",").collect { it.trim() }.toSet()
            programs.addLink(origin, destinations)
        }
    }
}
