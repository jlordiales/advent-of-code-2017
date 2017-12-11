package me.jlordiales.aoc.Day9

import me.jlordiales.aoc.input.Input
import spock.lang.Specification
import spock.lang.Unroll


class Day9Test extends Specification {

    @Unroll
    def "input score"() {
        expect:
        Day9.score(input) == result

        where:
        input                           | result
        "{}"                            | 1
        "{{{}}}"                        | 6
        "{{},{}}"                       | 5
        "{{{},{},{{}}}}"                | 16
        "{<a>,<a>,<a>,<a>}"             | 1
        "{{<ab>},{<ab>},{<ab>},{<ab>}}" | 9
        "{{<!!>},{<!!>},{<!!>},{<!!>}}" | 9
        "{{<a!>},{<a!>},{<a!>},{<ab>}}" | 3
        Input.forDay(9)                 | 11846
    }

    def "remove garbage"() {
        expect:
        Day9.removeGarbage("{{<!>},{<!>},{<!>},{<a>}}") == "{{}}"
        Day9.removeGarbage("{<{},{},{{}}>}") == "{}"
        Day9.removeGarbage("{{<ab>},{<ab>},{<ab>},{<ab>}}") == "{{},{},{},{}}"
        Day9.removeGarbage("{{<!!>},{<!!>},{<!!>},{<!!>}}") == "{{},{},{},{}}"
    }

    @Unroll
    def "garbage size"() {
        expect:
        Day9.garbageSize(input) == result

        where:
        input                           | result
        "<random characters>"           | 17
        "<>"                            | 0
        "<<<<>"                         | 3
        "<{!>}>"                        | 2
        "<!!>"                          | 0
        "{{<ab>},{<ab>},{<ab>},{<ab>}}" | 8
        Input.forDay(9)                 | 8
    }
}
