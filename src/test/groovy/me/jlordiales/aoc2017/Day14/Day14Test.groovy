package me.jlordiales.aoc2017.Day14

import spock.lang.Specification
import spock.lang.Unroll


class Day14Test extends Specification {

    @Unroll
    def "squares used for #input == #squaresUsed"() {
        expect:
        Day14.squaresUsed(input) == squaresUsed

        where:
        input      | squaresUsed
        "flqrgnkx" | 8108
        "oundnydw" | 8106
    }

    @Unroll
    def "hex to binary #hex == #binary"() {
        expect:
        Day14.hexToBin(hex) == binary

        where:
        hex   | binary
        "f"   | "1111"
        "0"   | "0000"
        "010" | "000000010000"

    }

    @Unroll
    def "regions for #input"() {
        expect:
        Day14.regions(input) == numberOfRegions

        where:
        input      | numberOfRegions
        "flqrgnkx" | 1242
        "oundnydw" | 1164
    }
}
