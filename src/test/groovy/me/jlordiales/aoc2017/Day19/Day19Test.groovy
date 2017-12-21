package me.jlordiales.aoc2017.Day19

import me.jlordiales.aoc2017.input.Input
import spock.lang.Specification


class Day19Test extends Specification {

    def "test example"() {
        given:
        def input = """     
    |          
    |  +--+    
    A  |  C    
F---|----E|--+ 
    |  |  |  D 
    +B-+  +--+"""

        expect:
        Day19.lettersFound(input) == "ABCDEF"
        Day19.pathLength(input) == 38
    }

    def "test input"() {
        expect:
        Day19.lettersFound(Input.forDay(19)) == "SXPZDFJNRL"
        Day19.pathLength(Input.forDay(19)) == 18126
    }
}
