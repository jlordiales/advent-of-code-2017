package me.jlordiales.aoc2017.Day3


class Day3 {

    static int distanceFromCellWithNumber(int number) {
        def matrix = spiralMatrix(number, { row, column, matrix -> previousValue(row, column, matrix) + 1 })
        manhatanDistanceBetween(indexFor(matrix, 1), indexFor(matrix, number))
    }

    static int firstValueWrittenBiggerThan(int number) {
        def matrix = spiralMatrix(number, { row, column, matrix -> adjacentValues(row, column, matrix).sum() })
        matrix.flatten().findAll { it > number }.min()
    }

    private static manhatanDistanceBetween(def oneIndex, def numberIndex) {
        Math.abs(oneIndex[0] - numberIndex[0]) + Math.abs(oneIndex[1] - numberIndex[1])
    }

    static List<List<Integer>> spiralMatrix(int stopValue, Closure<Integer> nextElementCalculator) {
        def matrix = [[1]]
        while (!matrix.flatten().any { it > stopValue }) {
            addLayer(matrix, nextElementCalculator)
        }
        matrix
    }

    private static addLayer(List<List<Integer>> matrix, Closure<Integer> nextElementCalculator) {
        addColumn(matrix, nextElementCalculator)
        addRow(matrix, nextElementCalculator)
        matrix
    }

    static void addRow(List<List<Integer>> matrix, Closure<Integer> nextElementCalculator) {
        isOdd(matrix.size()) ? addLastRow(matrix, nextElementCalculator) : addFirstRow(matrix, nextElementCalculator)
    }

    static void addColumn(List<List<Integer>> matrix, Closure<Integer> nextElementCalculator) {
        isOdd(matrix.size()) ? addLastColumn(matrix, nextElementCalculator) : addFirstColumn(matrix, nextElementCalculator)
    }

    static def addFirstRow(List<List<Integer>> matrix, Closure<Integer> nextElementCalculator) {
        for (int i = matrix.size() - 1; i >= 0; i--) {
            matrix[0][i] = nextElementCalculator(0, i, matrix)
        }
    }

    static void addLastRow(List<List<Integer>> matrix, Closure<Integer> nextElementCalculator) {
        int size = matrix.size()
        for (int i = 0; i < size; i++) {
            matrix[size - 1][i] = nextElementCalculator(size - 1, i, matrix)
        }
    }

    static void addLastColumn(List<List<Integer>> matrix, Closure<Integer> nextElementCalculator) {
        expandMatrix(matrix)
        int size = matrix.size()
        for (int i = size - 1; i >= 0; i--) {
            matrix[i][size - 1] = nextElementCalculator(i, size - 1, matrix)
        }
    }

    static def addFirstColumn(List<List<Integer>> matrix, Closure<Integer> nextElementCalculator) {
        expandMatrix(matrix)
        for (int i = 0; i < matrix.size(); i++) {
            matrix[i][0] = nextElementCalculator(i, 0, matrix)
        }
    }

    private static expandMatrix(List<List<Integer>> matrix) {
        def nextSize = matrix.size() + 1

        if (isOdd(matrix.size())) {
            matrix.each { it << 0 }
            matrix.add(0, [0] * nextSize)
        } else {
            matrix.each { it.add(0, 0) }
            matrix << [0] * nextSize
        }
    }

    static int previousValue(int row, int column, List<List<Integer>> matrix) {
        int size = matrix.size()
        if (row == 0) {
            return column == size - 1 ? matrix[row + 1][column] : matrix[row][column + 1]
        } else if (row == size - 1) {
            return column == 0 ? matrix[row - 1][column] : matrix[row][column - 1]
        } else if (column == 0) {
            return matrix[row - 1][column]
        } else if (column == size - 1) {
            return matrix[row + 1][column]
        }
    }

    static def adjacentValues(int row, int column, List<List<Integer>> matrix) {
        adjacentIndexes(row, column, matrix).collect { r, c -> matrix[r][c] }
    }

    protected static adjacentIndexes(int row, int column, List<List<Integer>> matrix) {
        [[row, row + 1, row - 1],
         [column, column + 1, column - 1]].combinations()
                                          .findAll { it != [row, column] }
                                          .findAll { inRange(it, matrix) }
    }

    static boolean inRange(List<Integer> cellIndex, List<List<Integer>> matrix) {
        (0..matrix.size() - 1).containsAll(cellIndex)
    }

    private static isOdd(int size) {
        size % 2 == 1
    }

    static def indexFor(List<List<Integer>> matrix, int number) {
        int row = matrix.findIndexOf { it.contains(number) }
        int column = matrix[row].indexOf(number)
        [row, column]
    }
}
