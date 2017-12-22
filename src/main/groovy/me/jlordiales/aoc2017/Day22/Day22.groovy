package me.jlordiales.aoc2017.Day22

import java.util.stream.Stream

import static me.jlordiales.aoc2017.Day22.NodeState.*


class Day22 {

    static solveFirstHalf(String input) {
        numberOfInfected(newStateFirstHalf(), input, 10000)
    }

    static solveSecondHalf(String input) {
        numberOfInfected(newStateSecondHalf(), input, 10000000)
    }

    static numberOfInfected(Closure<NodeState> stateFunction, String input, long limit) {
        def grid = parseInput(input)
        def carrier = new Carrier(currentPosition: startingPosition(input))

        Stream.generate({ carrier.burst(grid, stateFunction) })
              .limit(limit)
              .filter({ it == INFECTED })
              .count()
    }

    static Closure<NodeState> newStateFirstHalf() {
        { currentState ->
            currentState == INFECTED ? CLEAN : INFECTED
        }
    }

    static Closure<NodeState> newStateSecondHalf() {
        { currentState ->
            switch (currentState) {
                case INFECTED: return FLAGGED
                case CLEAN: return WEAKENED
                case FLAGGED: return CLEAN
                case WEAKENED: return INFECTED
            }
        }
    }

    static Map<List<Integer>, NodeState> parseInput(String input) {
        def grid = new HashMap()
        input.readLines().eachWithIndex { String entry, int i ->
            entry.trim().getChars().eachWithIndex { Character character, int j ->
                if (character == '#') {
                    grid.put([i, j], INFECTED)
                }
            }
        }
        grid.withDefault { CLEAN }
    }

    static def startingPosition(String input) {
        def lines = input.readLines()
        def middleRow = (int) lines.size() / 2
        def middleColumn = (int) lines[middleRow].trim().getChars().size() / 2
        [middleRow, middleColumn]
    }
}
