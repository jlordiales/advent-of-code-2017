package me.jlordiales.aoc2017.Day8

import groovy.transform.Immutable

@Immutable
class Operation {
    String op
    Integer opAmount

    void applyTo(Registers registers, String targetRegister) {
        int currentValue = registers.getValue(targetRegister)

        if (op == "dec") {
            registers.setValue(targetRegister, currentValue - opAmount)
        } else {
            registers.setValue(targetRegister, currentValue + opAmount)
        }
    }
}
