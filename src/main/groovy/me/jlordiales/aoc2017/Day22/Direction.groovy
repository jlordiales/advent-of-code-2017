package me.jlordiales.aoc2017.Day22


enum Direction {
    DOWN, UP, LEFT, RIGHT

    def turnRight() {
        switch (this) {
            case UP: return RIGHT
            case LEFT: return UP
            case RIGHT: return DOWN
            case DOWN: return LEFT
        }
    }

    def turnLeft() {
        switch (this) {
            case UP: return LEFT
            case LEFT: return DOWN
            case RIGHT: return UP
            case DOWN: return RIGHT
        }
    }

    def reverse() {
        switch (this) {
            case UP: return DOWN
            case LEFT: return RIGHT
            case RIGHT: return LEFT
            case DOWN: return UP
        }
    }
}
