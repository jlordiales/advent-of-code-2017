package me.jlordiales.aoc.day1


class Day1 {
    static firstHalf() {
        { i,input -> i + 1 }
    }

    static secondHalf() {
        { i,input -> i + input.size() / 2 }
    }

    static int solve(String input, Closure nextIndexFunction) {
        int sum = 0
        input.eachWithIndex { String number, int i ->
            if (input.charAt(i) == nextChar(input, i, nextIndexFunction)) {
                sum += Integer.valueOf(number)
            }
        }
        sum
    }

    private static char nextChar(String input, int index, Closure nextIndexFunction) {
        int nextIndex = nextIndexFunction(index, input)
        return input.charAt(nextIndex % input.size())
    }
}
