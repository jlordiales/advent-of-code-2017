package me.jlordiales.aoc2017.Day21

import spock.lang.Specification


class PatternTest extends Specification {

    def "from line"(){
        when:
        def patterh = Pattern.fromLine("../.. => ..#/#.#/###")

        then:
        patterh.input == "../.."
        patterh.output == "..#/#.#/###"
    }

    def "matches"() {
        given:
        def patterh = Pattern.fromLine("../.# => ##./#../...")
        def rows = [['#', '.', '.', '#'],
                    ['.', '.', '.', '.'],
                    ['.', '.', '.', '.'],
                    ['#', '.', '.', '#']]

        def matrix = new Matrix(matrix: rows)

        when:
        def subMatrices = matrix.subMatricesOfSize(2)

        then:
        patterh.matches(subMatrices[0][0])
        patterh.matches(subMatrices[0][1])
        patterh.matches(subMatrices[1][0])
        patterh.matches(subMatrices[1][1])
    }

    def "matches 2"() {
        given:
        def patterh = new Pattern(input: ".#./..#/###")

        expect:
        patterh.matches(Matrix.fromString(".#./..#/###"))
        patterh.matches(Matrix.fromString(".#./#../###"))
        patterh.matches(Matrix.fromString("#../#.#/##."))
        patterh.matches(Matrix.fromString("###/..#/.#."))
    }

    def "flip and rotate"() {
        given:
        def patterh = new Pattern(input: ".#./..#/###")

        expect:
        patterh.flipVertical().input == "###/..#/.#."
        patterh.flipHorizontal().input == ".#./#../###"
        patterh.rotate().input == "#../#.#/##."
    }
}
