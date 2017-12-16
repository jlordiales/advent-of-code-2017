package me.jlordiales.aoc2017.Day8

import groovy.transform.Immutable

@Immutable
class Instruction {
    String registerToModify
    Operation operation
    Condition condition

    static Instruction fromLine(String line) {
        def matcher = line.trim() =~ /(.*) (dec|inc) (-{0,1}\d+) if (.*)/
        if (matcher.matches()) {
            def groups = matcher[0]
            def targetRegister = groups[1]
            def op = groups[2]
            def value = groups[3]
            def condition = groups[4]

            return new Instruction(targetRegister, new Operation(op, Integer.valueOf(value)), Condition.from(condition))
        }
        null
    }

    void applyTo(Registers registers) {
        if (condition.isTrue(registers)) {
            operation.applyTo(registers, registerToModify)
        }
    }
}
