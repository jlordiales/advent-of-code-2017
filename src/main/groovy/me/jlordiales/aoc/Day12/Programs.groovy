package me.jlordiales.aoc.Day12

class Programs {
    Map<String, Set<String>> programs = new HashMap<>()

    def addLink(String from, Set<String> to) {
        programs.put(from, to)
    }

    def groupForProgram(String program) {
        def visited = [program] as Set
        def queued = programs.get(program).asList()

        while (!queued.isEmpty()) {
            def next = queued.pop()
            visited << next
            queued.addAll(programs.get(next).findAll { !visited.contains(it) })
        }

        visited
    }

    def allGroups() {
        programs.keySet().collect([] as Set) { groupForProgram(it) }
    }
}
