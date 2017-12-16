package me.jlordiales.aoc2017.Day7

import groovy.transform.Canonical

@Canonical
class ProgramInfo {
    String name
    int weight
    Set<ProgramInfo> programsAbove = []

    int totalWeight() {
        if (programsAbove.isEmpty()) {
            return weight
        }
        weight + subtowersWeight().sum()
    }

    def subtowersWeight() {
        programsAbove.collect { it.totalWeight() }
    }

    def isBalanced() {
        (subtowersWeight() as Set).size() <= 1
    }

    static List<ProgramInfo> fromLines(List<String> lines) {
        def lineComponents = lines.collect { lineComponents(it.trim()) }
        Map<String, ProgramInfo> nodesByName = lineComponents.collectEntries { [it.name, new ProgramInfo(name: it.name, weight: it.weight)] }
        lineComponents.each {
            def programsAbove = it.programNames.collect { node -> nodesByName[node] }
            nodesByName[it.name].programsAbove = programsAbove
        }
        nodesByName.values().collect()
    }

    private static def lineComponents(String line) {
        def matcher = line =~ /(.*)\(([0-9]*)\)( -> (.*))*/
        if (matcher.matches()) {
            def groups = matcher[0].findAll { it != null }
            if (groups.size() > 3) {
                return ["name"        : groups[1].trim(),
                        "weight"      : Integer.valueOf(groups[2]),
                        "programNames": groups[4].tokenize(',').collect { it.trim() }]
            }

            return ["name"        : groups[1].trim(),
                    "weight"      : Integer.valueOf(groups[2]),
                    "programNames": []]
        }
        null
    }
}
