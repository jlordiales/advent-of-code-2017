package me.jlordiales.aoc.Day8

import spock.lang.Specification


class ConditionTest extends Specification {

    def "From line"() {
        when:
        def condition = Condition.from("qn == 0")

        then:
        condition.register == "qn"
        condition.op == "=="
        condition.targetValue == 0

    }
}
