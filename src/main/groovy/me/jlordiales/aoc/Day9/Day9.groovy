package me.jlordiales.aoc.Day9

class Day9 {

    static int score(String input) {
        def groups = []
        def score = 0
        removeGarbage(input).getChars().each {
            if (it == '{') {
                groups << it
            } else if (it == '}') {
                score += groups.size()
                groups.pop()
            }
        }
        score
    }

    static String removeGarbage(String input) {
        String withoutNegations = removeNegations(input)
        withoutNegations.replaceAll("<(.*?)>","")
    }

    static int garbageSize(String input) {
        String withoutNegations = removeNegations(input)
        def size = 0
        withoutNegations.eachMatch(".*?<(.*?)>.*?") { groups ->
            size += groups[1].size()
        }
        size
    }

    protected static removeNegations(String input) {
        input.replaceAll("(!.)", "")
    }
}
