package me.jlordiales.aoc2017.day2

class Day2 {

    static int checksum(String input, Closure<Object> rowReducer) {
        checksum(inputToMatrix(input), rowReducer)
    }

    static int checksum(def matrix, Closure<Object> rowReducer) {
        matrix.collect(rowReducer).sum()
    }

    static def rowReducerFirstHalf() {
        { row -> row.max() - row.min() }
    }

    static def rowReducerSecondHalf() {
        { row ->
            def rowPair = findFirstPairSatisfying(row) { x, y -> x % y == 0 }
            rowPair.isEmpty() ? 0 : (int) rowPair[1] / rowPair[0]
        }
    }

    private static def findFirstPairSatisfying(List<Integer> list, Closure filter) {
        allPairs(list).find { filter(it[1], it[0]) }
    }

    private static allPairs(List<Integer> list) {
        list.subsequences()
            .findAll { it.size() == 2 }
            .collect { it.sort() }
    }

    private static inputToMatrix(String input) {
        input.readLines()
             .collect { rowForInput(it) }
             .inject([]) { acc, val -> acc << val }
    }

    private static rowForInput(String line) {
        line.split("\t").collect { Integer.valueOf(it) }
    }
}
