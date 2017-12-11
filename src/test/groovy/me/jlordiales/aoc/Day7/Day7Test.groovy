package me.jlordiales.aoc.Day7

import me.jlordiales.aoc.input.Input
import spock.lang.Specification


class Day7Test extends Specification {
    def "find program at base"() {
        given:
        def input = """pbga (66)
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



        expect:
        Day7.findProgramAtBase(input).name == "tknk"
    }

    def "Weight balance"() {
        given:
        def input = """pbga (66)
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

        expect:
        Day7.balanceDifference(input) == 8
    }

    def "find program at base for input"() {
        expect:
        Day7.findProgramAtBase(Input.forDay(7)).name == "uownj"
    }

    def "weight balance for input"() {
        expect:
        Day7.balanceDifference(Input.forDay(7)) == 596
    }

}
