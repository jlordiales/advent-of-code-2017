package me.jlordiales.aoc2017.Day13

import groovy.transform.Immutable

@Immutable
class Layer {
    int depth
    int range

    def wouldCatchPacketAtStep(int step) {
        scannerPositionAfter(depth + step) == 0
    }

    private def scannerPositionAfter(int n) {
        def offset = n % ((range - 1) * 2)
        if (offset < range) {
            offset
        } else {
            2 * (range - 1) - offset
        }
    }
}
