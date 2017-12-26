package me.jlordiales.aoc2017.Day24

class Day24 {

    static List<Component> parseComponents(String input) {
        input.readLines()
             .collect { it.trim().tokenize('/').collect { Integer.valueOf(it) } }
             .collect { new Component(port1: it[0], port2: it[1]) }
    }

    static strongestBridge(String input) {
        maxStrength(bridges(input))
    }

    static longestBridge(String input) {
        def bridgeByLength = bridges(input).groupBy { it.size() }
        def maxLength = bridgeByLength.keySet().max()

        maxStrength(bridgeByLength.get(maxLength))
    }

    static def maxStrength(bridges) {
        bridges.collect { b -> b.inject(0) { acc, val -> acc + val.strength() } }
               .max()
    }

    private static bridges(String input) {
        def components = parseComponents(input)
        def starting = components.findAll { it.port1 == 0 || it.port2 == 0 }
        starting.collectMany { bridgeFrom(it.withUsedPort(0), components) }
    }

    static def bridgeFrom(Component component, List<Component> components) {
        def bridges = []
        visit(component, [], components, bridges)

        bridges
    }

    static def visit(Component component, List<Component> visited, List<Component> components, List<List<Component>> paths) {
        visited.push(component)
        def links = linksFrom(component, components).findAll { !visited.contains(it) }
        links.each { visit(it, visited, components, paths) }

        if (links.isEmpty()) {
            paths << new ArrayList<Component>(visited)
        }
        visited.remove(component)
    }

    static def linksFrom(Component component, List<Component> components) {
        def portToMatch = component.unusedPort()
        components.findAll { portToMatch == it.port1 || portToMatch == it.port2 }
                  .collect { it.withUsedPort(portToMatch) }
    }
}
