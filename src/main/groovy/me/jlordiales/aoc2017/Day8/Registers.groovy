package me.jlordiales.aoc2017.Day8


class Registers {
    private Map<String, Integer> registers = new HashMap<>()
    private Integer highestValueSoFar = Integer.MIN_VALUE

    Integer getValue(String register) {
        registers.getOrDefault(register, 0)
    }

    void setValue(String register, Integer value) {
        registers.put(register, value)
        if (value > highestValueSoFar) {
            highestValueSoFar = value
        }
    }

    def allValues() {
        registers.values()
    }

    def getHighestValueSoFar() {
        highestValueSoFar
    }

}
