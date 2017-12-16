package me.jlordiales.aoc2017.Day15

import spock.lang.Specification


class GeneratorTest extends Specification {

    def "next value test"() {
        given:
        def generator = new Generator(previousValue: 65, factor: 16807)

        expect:
        generator.nextValue() == 1092455
        generator.nextValue() == 1181022009
        generator.nextValue() == 245556042
        generator.nextValue() == 1744312007
        generator.nextValue() == 1352636452
    }

    def "next value2 test"() {
        given:
        def generator = new Generator(previousValue: 65, factor: 16807)

        expect:
        generator.nextValueMultipleOf(4) == 1352636452
        generator.nextValueMultipleOf(4) == 1992081072
        generator.nextValueMultipleOf(4) == 530830436
        generator.nextValueMultipleOf(4) == 1980017072
        generator.nextValueMultipleOf(4) == 740335192
    }
}
