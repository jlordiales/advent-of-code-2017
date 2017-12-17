package me.jlordiales.aoc2017.Day16

import java.util.stream.Stream

import static com.codepoetics.protonpack.StreamUtils.takeUntil
import static java.util.stream.Collectors.toList

class Day16 {
    public static final List<Character> INITIAL_POSITIONS = ('a'..'p').collect { it.toCharacter() }

    static String dance(String input) {
        processInput(INITIAL_POSITIONS, input).join()
    }

    static def danceNTimes(String input, int n) {
        def fullCycle = [INITIAL_POSITIONS] + danceUntilBackToStartingPosition(input).collect(toList())
        fullCycle.get(n % fullCycle.size()).join()
    }

    private static Stream<List<Character>> danceUntilBackToStartingPosition(String input) {
        def allPositions = positionsStream(input)
        takeUntil(allPositions.skip(1)) { it == INITIAL_POSITIONS }
    }

    private static Stream<List<Character>> positionsStream(String input) {
        Stream.iterate(INITIAL_POSITIONS) { processInput(it, input) }
    }

    private static List<Character> processInput(List<Character> programs, String input) {
        input.tokenize(',').each {
            programs = movePrograms(it, programs)
        }

        programs
    }

    private static List<Character> movePrograms(String move, List<Character> positions) {
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

    private static List<Character> swapProgramNames(String nameA, String nameB, List<Character> characters) {
        swapPositions(characters.findIndexOf { it.toString() == nameA }, characters.findIndexOf { it.toString() == nameB }, characters)
    }

    private static List<Character> swapPositions(int positionA, int positionB, List<Character> characters) {
        def swappedList = new ArrayList(characters)
        def positionBItem = characters[positionB]
        swappedList[positionB] = swappedList[positionA]
        swappedList[positionA] = positionBItem
        swappedList
    }

    private static List<Character> moveXProgramsFromEndToFront(int x, List<Character> positions) {
        int dropQuantity = positions.size() - x

        def front = positions.take(dropQuantity)
        def end = positions.drop(dropQuantity)
        end + front
    }
}
