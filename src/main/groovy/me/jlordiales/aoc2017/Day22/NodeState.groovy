package me.jlordiales.aoc2017.Day22


enum NodeState {
    INFECTED({ Direction direction -> direction.turnRight() }),
    WEAKENED({ Direction direction -> direction }),
    FLAGGED({ Direction direction -> direction.reverse() }),
    CLEAN({ Direction direction -> direction.turnLeft() })

    final Closure<Direction> directionFunction
    NodeState(Closure<Direction> directionFunction) {
        this.directionFunction = directionFunction
    }




}