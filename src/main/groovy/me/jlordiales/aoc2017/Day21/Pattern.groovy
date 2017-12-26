package me.jlordiales.aoc2017.Day21

import groovy.transform.Canonical

@Canonical
class Pattern {
    String input
    String output

    static fromInput(String input) {
        input.readLines().collect { it.trim() }.collectMany {
            def original = fromLine(it)
            def rotated = original.rotate()
            [original,
             original.flipVertical(),
             original.flipHorizontal(),
             original.flipVertical().flipHorizontal(),
             original.flipHorizontal().flipVertical(),
             rotated,
             rotated.flipVertical(),
             rotated.flipHorizontal(),
             rotated.flipHorizontal().flipVertical(),
             rotated.flipVertical().flipHorizontal()]
        }
    }

    static fromLine(String line) {
        def inputOutput = line.tokenize("=>").collect { it.trim() }
        new Pattern(input: inputOutput[0], output: inputOutput[1])
    }

    boolean matches(Matrix matrix) {
        input == matrix.toString()
    }

    Matrix outputMatrix() {
        Matrix.fromString(output)
    }

    Pattern flipHorizontal() {
        def flippedInputPattern = input.tokenize('/')
                                       .collect { it.reverse() }
                                       .join('/')
        new Pattern(input: flippedInputPattern, output: this.output)
    }

    Pattern flipVertical() {
        def flippedInputPattern = input.tokenize('/').reverse().join('/')
        new Pattern(input: flippedInputPattern, output: this.output)
    }

    Pattern rotate() {
        def rows = input.tokenize('/').reverse().collect { it.chars.collect { it } }.transpose()
        def input = rows.collect { it.join() }.join('/')
        new Pattern(input: input, output: this.output)
    }
}