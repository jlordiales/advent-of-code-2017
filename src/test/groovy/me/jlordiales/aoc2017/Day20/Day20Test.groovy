package me.jlordiales.aoc2017.Day20

import me.jlordiales.aoc2017.input.Input
import spock.lang.Specification

class Day20Test extends Specification {

    def "test example"() {
        given:
        def input = """p=<3,0,0>, v=<2,0,0>, a=<-1,0,0>
                       p=<4,0,0>, v=<0,0,0>, a=<-2,0,0>"""

        expect:
        Day20.particleClosestToOrigin(input) == 0
    }

    def "test input"() {
        expect:
        Day20.particleClosestToOrigin(Input.forDay(20)) == 170
    }

    def "remove colliding particles example"() {
        given:
        def input = """p=<-6,0,0>, v=<3,0,0>, a=<0,0,0>    
                       p=<-4,0,0>, v=<2,0,0>, a=<0,0,0>
                       p=<-2,0,0>, v=<1,0,0>, a=<0,0,0>
                       p=<3,0,0>, v=<-1,0,0>, a=<0,0,0>"""

        expect:
        Day20.removeCollidingParticles(input).size() == 1
    }

    def "remove colliding particles input"() {
        expect:
        Day20.removeCollidingParticles(Input.forDay(20)).size() == 571
    }
}
