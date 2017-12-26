package me.jlordiales.aoc2017.Day21

import spock.lang.Specification


class MatrixTest extends Specification {

    def "sub matrices"() {
        given:
        def rows = [['#', '.', '.', '#'],
                    ['.', '.', '.', '.'],
                    ['.', '.', '.', '.'],
                    ['#', '.', '.', '#']]

        def matrix = new Matrix(matrix: rows)

        when:
        def subMatrices = matrix.subMatricesOfSize(2)

        then:
        subMatrices.size() == 2
        subMatrices[0][0].matrix == [['#', '.'],
                                     ['.', '.']]
        subMatrices[0][1].matrix == [['.', '#'],
                                     ['.', '.']]
        subMatrices[1][0].matrix == [['.', '.'],
                                     ['#', '.']]
        subMatrices[1][1].matrix == [['.', '.'],
                                     ['.', '#']]

        and:
        Matrix.join(subMatrices) == matrix
    }

    def "on pixels"() {
        given:
        def rows = [['#', '.', '.', '#'],
                    ['.', '.', '.', '.'],
                    ['.', '.', '.', '.'],
                    ['#', '.', '.', '#']]

        def matrix = new Matrix(matrix: rows)

        expect:
        matrix.onPixels() == 4
    }

    def "toString test"() {
        given:
        def rows = [['#', '.', '.', '#'],
                    ['.', '.', '.', '.'],
                    ['.', '.', '.', '.'],
                    ['#', '.', '.', '#']]

        def matrix = new Matrix(matrix: rows)

        expect:
        matrix.toString() == "#..#/..../..../#..#"
    }

}
