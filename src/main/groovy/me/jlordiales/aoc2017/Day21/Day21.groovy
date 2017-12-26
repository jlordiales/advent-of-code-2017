package me.jlordiales.aoc2017.Day21

import java.util.stream.Stream

class Day21 {

    static solve(String input, int iterations) {
        List<Pattern> patterns = Pattern.fromInput(input)

        Stream.iterate(Matrix.initial(), { expand(it, patterns) })
              .skip(iterations)
              .findFirst()
              .get()
              .onPixels()
    }

    protected static expand(Matrix matrix, List<Pattern> patterns) {
        List<List<Matrix>> subMatrices = matrix.size() % 2 == 0 ? matrix.subMatricesOfSize(2) : matrix.subMatricesOfSize(3)
        def newSubMatrices = subMatrices.collectNested { m ->
            patterns.find { it.matches(m) }.outputMatrix()
        }
        Matrix.join(newSubMatrices)
    }


}
