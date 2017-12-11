package me.jlordiales.aoc.Day11


enum Direction {
    N([1,0]),
    NE([0.5,0.5]),
    NW([0.5,-0.5]),
    S([-1,0]),
    SW([-0.5,-0.5]),
    SE([-0.5,0.5]),
    W([-1,1]),
    E([-1,1])

    private final def relativeMovement

    Direction(def relativeMovement) {
        this.relativeMovement = relativeMovement
    }

    def move(def startingPoint) {
        [startingPoint[0] + relativeMovement[0], startingPoint[1] + relativeMovement[1]]
    }

}