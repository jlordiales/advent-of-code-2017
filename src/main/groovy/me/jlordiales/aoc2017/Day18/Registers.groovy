package me.jlordiales.aoc2017.Day18

import java.util.function.UnaryOperator

class Registers {
    private Map<String, Long> registers = new HashMap<>()

    Long getValue(String register) {
        registers.getOrDefault(register, 0L)
    }

    void setValue(String register, Long value) {
        registers.put(register, value)
    }

    void computeValue(String register, UnaryOperator<Long> computeFunction) {
        registers.compute(register, { k, v -> computeFunction.apply(v ?: 0) })
    }


}
