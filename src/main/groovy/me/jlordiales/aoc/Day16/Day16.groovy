package me.jlordiales.aoc.Day16

import com.codepoetics.protonpack.StreamUtils

import java.util.stream.Stream

class Day16 {
    public static final List<Character> INITIAL_POSITIONS = ('a'..'p').collect { it.toCharacter() }

    static def dance(String input) {
        danceNTimes(input, 1)
    }

    static def danceNTimes(String input, int n) {
        positionsStream(input).skip(n)
                              .findFirst()
                              .get()
                              .join()
    }

    private static Stream<List<Character>> positionsStream(String input) {
        Stream.iterate(INITIAL_POSITIONS) { dance(it, input) }
    }

    static def cycleSize(String input) {
        def cycleStream = StreamUtils.takeUntilInclusive(positionsStream(input).skip(1), { it == INITIAL_POSITIONS })

        cycleStream.count()
    }

    static def dance(List<Character> programs, String input) {
        input.tokenize(',').each {
            programs = movePrograms(it, programs)
        }

        programs
    }

    static List<Character> movePrograms(String move, List<Character> positions) {
        if (move.startsWith("s")) {
            return moveXProgramsFromEndToFront(Integer.valueOf(move.substring(1)), positions)
        } else if (move.startsWith("x")) {
            def parts = move.substring(1).tokenize('/')
            return swapPositions(Integer.valueOf(parts[0]), Integer.valueOf(parts[1]), positions)
        } else {
            def parts = move.substring(1).tokenize('/')
            return swapProgramNames(parts[0], parts[1], positions)
        }
    }

    static List<Character> swapProgramNames(String nameA, String nameB, List<Character> characters) {
        swapPositions(characters.findIndexOf { it.toString() == nameA }, characters.findIndexOf { it.toString() == nameB }, characters)
    }

    static List<Character> swapPositions(int positionA, int positionB, List<Character> characters) {
        def swappedList = new ArrayList(characters)
        def positionBItem = characters[positionB]
        swappedList[positionB] = swappedList[positionA]
        swappedList[positionA] = positionBItem
        swappedList
    }

    static List<Character> moveXProgramsFromEndToFront(int x, List<Character> positions) {
        int dropQuantity = positions.size() - x

        def front = positions.take(dropQuantity)
        def end = positions.drop(dropQuantity)
        end + front
    }
}
