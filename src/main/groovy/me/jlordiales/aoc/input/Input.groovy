package me.jlordiales.aoc.input


class Input {

    static def forDay(int day) {
        new Input().getClass().getClassLoader().getResourceAsStream("inputs/day${day}").getText("utf-8")
    }
}
