package me.jlordiales.aoc.Day11


class Day11 {
    static int numberOfSteps(String input) {
        travelledDistances(parseInput(input))[-1]
    }

    static int maxDistanceTraveled(String input) {
        travelledDistances(parseInput(input)).max()
    }

    protected static parseInput(String input) {
        input.tokenize(",").collect { Direction.valueOf(it.toUpperCase()) }
    }

    static def travelledDistances(List<Direction> directions) {
        def currentPosition = [0,0]
        directions.collect {
            currentPosition = it.move(currentPosition)
            steps(currentPosition)
        }
    }

    protected static steps(List<Integer> currentPosition) {
        Math.abs(currentPosition[0]) + Math.abs(currentPosition[1])
    }
}
