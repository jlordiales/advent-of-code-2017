package me.jlordiales.aoc2017.Day20

import groovy.transform.Canonical

import static java.lang.Math.abs

@Canonical
class Particle {
    int id
    List<Integer> position, velocity, acceleration

    def update() {
        velocity[0] += acceleration[0]
        velocity[1] += acceleration[1]
        velocity[2] += acceleration[2]

        position[0] += velocity[0]
        position[1] += velocity[1]
        position[2] += velocity[2]
    }

    int distanceToOrigin() {
        abs(position[0]) + abs(position[1]) + abs(position[2])
    }
}
