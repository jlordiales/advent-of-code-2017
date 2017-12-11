package me.jlordiales.aoc.Day8

import groovy.transform.Immutable

@Immutable
class Condition {
    String register
    String op
    Integer targetValue

    static Condition from(String line) {
        def parts = line.split(" ")
        new Condition(register: parts[0], op: parts[1], targetValue: Integer.valueOf(parts[2]))
    }

    boolean isTrue(Registers registers) {
        int registerValue = registers.getValue(register)
        switch (op) {
            case '>':
                return registerValue > targetValue
            case '>=':
                return registerValue >= targetValue
            case '<':
                return registerValue < targetValue
            case '<=':
                return registerValue <= targetValue
            case '==':
                return registerValue == targetValue
            case '!=':
                return registerValue != targetValue
        }
        false
    }
}
