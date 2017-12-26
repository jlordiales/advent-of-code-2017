package me.jlordiales.aoc2017.Day24

import groovy.transform.Immutable

@Immutable(copyWith = true)
class Component {
    int port1, port2
    boolean port1Used = false
    boolean port2Used = false

    def withUsedPort(def port) {
        port == port1 ? this.copyWith(port1Used: true) : this.copyWith(port2Used: true)
    }

    def unusedPort() {
        if (port1Used && port2Used) {
            throw new IllegalStateException("Both ports are used")
        }
        port1Used ? port2 : port1
    }

    def strength() {
        port2 + port1
    }

    @Override
    String toString() {
        "$port1/$port2"
    }

    boolean equals(o) {
        if (this.is(o)) return true
        if (getClass() != o.class) return false

        Component component = (Component) o

        if (port1 != component.port1) return false
        if (port2 != component.port2) return false

        return true
    }

    int hashCode() {
        int result
        result = port1
        result = 31 * result + port2
        return result
    }
}
