package me.jlordiales.aoc.Day15

import groovy.transform.Canonical

import java.util.stream.LongStream

@Canonical
class Generator {
    long previousValue
    long factor

    long nextValue() {
        previousValue = (previousValue * factor) % Integer.MAX_VALUE
        previousValue
    }

    long nextValueMultipleOf(int n) {
        LongStream.generate { nextValue() }
                  .filter { x -> x % n == 0 }
                  .findFirst()
                  .asLong
    }

}
