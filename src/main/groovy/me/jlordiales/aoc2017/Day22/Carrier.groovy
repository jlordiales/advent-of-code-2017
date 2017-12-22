package me.jlordiales.aoc2017.Day22

import groovy.transform.Canonical

import static me.jlordiales.aoc2017.Day22.Direction.DOWN
import static me.jlordiales.aoc2017.Day22.Direction.LEFT
import static me.jlordiales.aoc2017.Day22.Direction.RIGHT
import static me.jlordiales.aoc2017.Day22.Direction.UP

@Canonical
class Carrier {
    def currentPosition
    Direction direction = UP

    NodeState burst(Map<List<Integer>, NodeState> grid, Closure<NodeState> stateFunction) {
        def nodeState = grid.get(currentPosition)
        def newState = stateFunction(nodeState)
        direction = nodeState.directionFunction(direction)

        grid.put(currentPosition, newState)
        currentPosition = stepForward()

        newState
    }

    def stepForward() {
        switch (direction) {
            case UP:
                return [currentPosition[0]-1, currentPosition[1]]
            case DOWN:
                return [currentPosition[0]+1, currentPosition[1]]
            case LEFT:
                return [currentPosition[0], currentPosition[1]-1]
            case RIGHT:
                return [currentPosition[0], currentPosition[1]+1]
        }
    }
}
