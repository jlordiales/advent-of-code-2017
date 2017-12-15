package me.jlordiales.aoc.Day15


class Day15 {

    static def lowerKBits(long n, int k) {
        n << (64 - k)
    }

    static def count(Generator generatorA, Generator generatorB) {
        def count = 0
        40000000.times {
            if (lowerKBits(generatorA.nextValue(), 16) == lowerKBits(generatorB.nextValue(), 16)) {
                count++
            }
        }
        count
    }

    static def count2(Generator generatorA, Generator generatorB) {
        def count = 0
        5000000.times {
            if (lowerKBits(generatorA.nextValueMultipleOf(4), 16) == lowerKBits(generatorB.nextValueMultipleOf(8), 16)) {
                count++
            }
        }
        count
    }
}
