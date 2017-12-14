package me.jlordiales.aoc.Day14

import me.jlordiales.aoc.Day10.Day10


class Day14 {
    static int squaresUsed(String input) {
        rowsForInput(input).sum { numberOfOnesIn(it) }
    }

    static int regions(String input) {
        allRegions(rowsForInput(input)).size()
    }

    static int numberOfOnesIn(String s) {
        s.findAll { it == "1" }.size()
    }

    private static List<String> rowsForInput(String input) {
        (0..<128).collect { i ->
            def knotHash = Day10.knotHash(input + "-${i}")
            hexToBin(knotHash)
        }
    }

    def static allRegions(List<String> matrix) {
        def regions = [] as Set
        matrix.eachWithIndex { String entry, int i ->
            entry.findIndexValues { it == '1' }
                 .each { regions << regionFor(i, it.toInteger(), matrix) }
        }
        regions
    }

    def static regionFor(int row, int column, List<String> matrix) {
        def visited = [[row, column]] as Set
        def queued = adjacentIndexes(row, column, matrix)

        while (!queued.isEmpty()) {
            def next = queued.pop()
            if (matrix[next[0]][next[1]] == '1') {
                visited << next
                queued.addAll(adjacentIndexes(next[0], next[1], matrix).findAll { !visited.contains(it) })
            }
        }
        visited
    }

    static boolean inRange(List<Integer> cellIndex, List<String> matrix) {
        (0..matrix.size() - 1).containsAll(cellIndex)
    }

    protected static adjacentIndexes(int row, int column, List<String> matrix) {
        [[row + 1, column],
         [row - 1, column],
         [row, column + 1],
         [row, column - 1]].findAll { inRange(it, matrix) }
    }

    static String hexToBin(String s) {
        String value = new BigInteger(s, 16).toString(2)
        String.format("%${s.length() * 4}s", value).replace(" ", "0")
    }
}
