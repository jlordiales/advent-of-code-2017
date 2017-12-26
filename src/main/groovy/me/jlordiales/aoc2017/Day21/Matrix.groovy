package me.jlordiales.aoc2017.Day21

import groovy.transform.Canonical

@Canonical
class Matrix {
    List<List<Character>> matrix = []

    static initial() {
        def matrix = [['.', '#', '.'],
                      ['.', '.', '#'],
                      ['#', '#', '#']]

        new Matrix(matrix: matrix)
    }

    private Matrix joinRight(Matrix m) {
        m.matrix.eachWithIndex { List<Character> entry, int i ->
            extendRow(entry, i)
        }
        this
    }

    private Matrix joinDown(Matrix m) {
        m.matrix.each {
            addRow(it)
        }
        this
    }

    int size() {
        matrix.size()
    }

    int onPixels() {
        matrix.flatten().count { it == '#' }
    }

    private void addRow(List<Character> row) {
        matrix.add(row)
    }

    private void extendRow(List<Character> row, int rowIndex) {
        if (rowIndex >= size()) {
            addRow(row)
        } else {
            matrix[rowIndex].addAll(row)
        }
    }

    List<List<Matrix>> subMatricesOfSize(int size) {
        if (matrix.size() % size != 0) {
            throw new IllegalArgumentException("Invalid size")
        }
        matrix.collate(size).collect { splitRowGroup(it, size) }
    }

    static Matrix join(List<List<Matrix>> matrices) {
        def joinedRight = matrices.collect { it.inject { Matrix acc, val -> acc.joinRight(val) } }
        joinedRight.inject { Matrix acc, val -> acc.joinDown(val) }
    }

    private static List<Matrix> splitRowGroup(List<List<Character>> rows, int size) {
        List<Matrix> matrices = [].withDefault { new Matrix() }
        rows.each {
            it.collate(size).eachWithIndex { List<Character> columns, int j ->
                matrices[j].addRow(columns)
            }
        }
        matrices
    }

    @Override
    String toString() {
        matrix.collect {it.join()}.join('/')
    }

    static Matrix fromString(String input) {
        def rows = input.tokenize('/').collect { it.chars.collect { it } }
        new Matrix(matrix: rows)
    }
}
