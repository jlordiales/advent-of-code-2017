package me.jlordiales.aoc2017.Day7

import spock.lang.Specification


class ProgramInfoTest extends Specification {
    def "parse line with other programs"() {
        given:
        def lines = """ pbga (66)
                        xhth (57)
                        ebii (61)
                        havc (66)
                        ktlj (57)
                        fwft (72) -> ktlj, cntj, xhth
                        qoyq (66)
                        padx (45) -> pbga, havc, qoyq
                        tknk (41) -> ugml, padx, fwft
                        jptl (61)
                        ugml (68) -> gyxo, ebii, jptl
                        gyxo (61)
                        cntj (57)"""

        when:
        def programs = ProgramInfo.fromLines(lines.readLines())

        then:
        programs.size() == 13
        def program = programs.find {it.name == "tknk"}
        program.weight == 41
        program.programsAbove.size() == 3
        program.programsAbove.name as Set == ["ugml", "padx", "fwft"] as Set
    }

    def "parse line without other programs"() {
        when:
        def programInfo = ProgramInfo.fromLines(["pbga (66)"])[0]

        then:
        programInfo.name == "pbga"
        programInfo.weight == 66
        programInfo.programsAbove.isEmpty()
    }
}
