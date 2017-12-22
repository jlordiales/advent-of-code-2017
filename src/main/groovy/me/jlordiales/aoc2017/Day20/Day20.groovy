package me.jlordiales.aoc2017.Day20

class Day20 {

    static def particleClosestToOrigin(String input) {
        List<Particle> particles = parseInput(input)

        350.times {
            particles.each { it.update() }
        }

        particles.min { it.distanceToOrigin() }.id
    }

    static def removeCollidingParticles(String input) {
        List<Particle> particles = parseInput(input)

        40.times {
            particles.removeAll(collidingParticles(particles))
            particles.each { it.update() }
        }
        particles
    }

    static List<Particle> collidingParticles(List<Particle> particles) {
        Map<List<Integer>, List<Particle>> particlesByPosition = particles.groupBy { it.position }
        particlesByPosition.entrySet().findAll { it.value.size() > 1 }.collect { it.value }.flatten()
    }

    private static List<Particle> parseInput(String input) {
        int i = 0
        input.readLines().collect { fromLine(it.trim(), i++) }
    }

    static Particle fromLine(String line, int id) {
        def matcher = line.trim() =~ /p=<(.*)>, v=<(.*)>, a=<(.*)>/
        if (matcher.matches()) {
            def position = matcher[0][1].tokenize(',').collect { Integer.valueOf(it) }
            def velocity = matcher[0][2].tokenize(',').collect { Integer.valueOf(it) }
            def acceleration = matcher[0][3].tokenize(',').collect { Integer.valueOf(it) }

            return new Particle(id: id, position: position, velocity: velocity, acceleration: acceleration)
        }
        null
    }
}
