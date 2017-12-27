package me.jlordiales.aoc2017.Day25

import groovy.transform.Canonical

@Canonical
class Tape {
    Map<Integer, Integer> values = [:].withDefault { 0 }
    int currentPosition = 0

    def currentValue() {
        values.get(currentPosition)
    }

    def writeToCurrentPosition(int value) {
        values.put(currentPosition, value)
    }

    def setNewPosition(int position) {
        currentPosition = position
    }
}
