package me.jlordiales.aoc2017.Day19

import java.util.stream.Stream

import static com.codepoetics.protonpack.StreamUtils.takeUntil
import static java.util.stream.Collectors.toList
import static me.jlordiales.aoc2017.Day19.Direction.*

class Day19 {

    static String lettersFound(String input) {
        pathToEnd(input).filter({ it.isLetter() })
                        .collect(toList())
                        .join()
    }

    static int pathLength(String input) {
        pathToEnd(input).count()
    }

    private static pathToEnd(String input) {
        def matrix = matrixForInput(input)

        def path = Stream.iterate(findStartingPoint(matrix), { next(it, matrix) })
        takeUntil(path, { it[0] == -1 }).map({ matrix[it[0]][it[1]] })
    }

    private static def next(def position, def matrix) {
        def row = position[0]
        def column = position[1]
        def direction = position[2]
        def valueInPosition = matrix[row][column]

        if (valueInPosition == '+') {
            if (direction == DOWN || direction == UP) {
                if (canGo(right(row, column), matrix)) {
                    return right(row, column)
                }
                if (canGo(left(row, column), matrix)) {
                    return left(row, column)
                }
            }

            if (direction == LEFT || direction == RIGHT) {
                if (canGo(down(row, column), matrix)) {
                    return down(row, column)
                }
                if (canGo(up(row, column), matrix)) {
                    return up(row, column)
                }
            }
        }

        if (direction == DOWN && canGo(down(row, column), matrix)) {
            return down(row, column)
        }
        if (direction == LEFT && canGo(left(row, column), matrix)) {
            return left(row, column)
        }
        if (direction == RIGHT && canGo(right(row, column), matrix)) {
            return right(row, column)
        }
        if (direction == UP && canGo(up(row, column), matrix)) {
            return up(row, column)
        }

        [-1, -1, null]
    }

    private static up(row, column) {
        return [row - 1, column, UP]
    }

    private static left(row, column) {
        return [row, column - 1, LEFT]
    }

    private static right(row, column) {
        return [row, column + 1, RIGHT]
    }

    private static down(row, column) {
        [row + 1, column, DOWN]
    }

    private static boolean canGo(def position, def matrix) {
        position[0] >= 0 &&
                position[0] < matrix.size() &&
                position[1] >= 0 &&
                position[1] < matrix[position[0]].size() &&
                matrix[position[0]][position[1]] != ' '
    }

    private static def findStartingPoint(def matrix) {
        def startingColumn = matrix[0].findIndexOf { it != ' ' }
        [0, startingColumn, DOWN]
    }

    private static def matrixForInput(String input) {
        input.readLines().findAll { !it.trim().isEmpty() }.collect { it.chars }
    }
}
