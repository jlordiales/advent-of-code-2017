package me.jlordiales.aoc.Day8

import spock.lang.Specification


class InstructionTest extends Specification {

    def "Parse instruction line"() {
        when:
        Instruction instruction = Instruction.fromLine("d dec -683 if qn == 0")

        then:
        instruction.operation.op == "dec"
        instruction.operation.opAmount == -683
        instruction.registerToModify == "d"
        instruction.condition.op == "=="
        instruction.condition.register == "qn"
        instruction.condition.targetValue == 0
    }

    def "apply instructions"() {
        given:
        Instruction instruction = Instruction.fromLine("d dec 683 if qn == 0")
        Registers registers = new Registers()

        when:
        instruction.applyTo(registers)

        then:
        registers.getValue("d") == -683
    }
}
