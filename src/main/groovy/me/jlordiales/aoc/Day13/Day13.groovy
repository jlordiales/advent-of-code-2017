package me.jlordiales.aoc.Day13

import java.util.stream.Stream

import static java.lang.Integer.MAX_VALUE
import static java.util.stream.IntStream.range

class Day13 {

    static def severityFor(String input) {
        def layers = parseLayers(input)
        caughtInLayers(layers, 0).mapToInt { it.depth * it.range }.sum()
    }

    static def minimumDelayToNotGetCaught(String input) {
        def layers = parseLayers(input)
        range(0, MAX_VALUE).filter { !wouldBeCaughtInState(layers, it) }
                           .findFirst()
                           .asInt
    }

    protected static wouldBeCaughtInState(List<Layer> layers, delay) {
        caughtInLayers(layers, delay).findFirst().isPresent()
    }

    private static Stream<Layer> caughtInLayers(List<Layer> layers, int delay) {
        layers.stream()
              .filter { it.wouldCatchPacketAtStep(delay) }
    }

    static def layerForLine(String line) {
        def matcher = line.trim() =~ /(\d*): (\d*)/
        if (matcher.matches()) {
            def depth = Integer.valueOf(matcher[0][1])
            def range = Integer.valueOf(matcher[0][2])
            return new Layer(range: range, depth: depth)
        }
        null
    }

    protected static parseLayers(String input) {
        input.readLines().collect { layerForLine(it) }
    }
}
