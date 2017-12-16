package me.jlordiales.aoc2017.Day10


class Day10 {

    static List<Integer> runRound(List<Integer> lengths) {
        def list = (0..255)
        runRound(list, lengths)[0]
    }

    static def knotHash(String input) {
        def list = (0..255)
        def asciiLengths = lengthsToAscii(input) + [17, 31, 73, 47, 23]
        def currentPosition = 0
        def skipSize = 0

        64.times {
            (list, currentPosition, skipSize) = runRound(list, asciiLengths, currentPosition, skipSize)
        }

        denseHash(list).collect { toHexString(it) }.join()
    }

    protected static toHexString(it) {
        def hexString = Integer.toHexString(it)
        hexString.size() == 1 ? "0${hexString}" : hexString
    }

    static def denseHash(List<Integer> list) {
        def denseHash = []
        def sparseHash = new ArrayList(list)
        16.times {
            denseHash << sparseHash.take(16).inject { acc, val -> acc ^ val }
            sparseHash = sparseHash.drop(16)
        }
        denseHash
    }

    static List<Integer> lengthsToAscii(String input) {
        input.getChars().collect { (int) it }
    }

    static def runRound(List<Integer> initialList,
                        List<Integer> lengths,
                        int initialCurrentPosition = 0,
                        int initialSkipSize = 0) {
        def list = new ArrayList<>(initialList)
        def currentPosition = initialCurrentPosition
        def skipSize = initialSkipSize

        lengths.each {
            processLength(list, it, currentPosition)
            currentPosition = (currentPosition + it + skipSize) % list.size()
            skipSize++
        }
        [list, currentPosition, skipSize]

    }

    static void processLength(List<Integer> list, int length, int currentPosition) {
        def reversedSublist = sublist(list, length, currentPosition).reverse()
        for (int i = 0; i < length; i++) {
            int nextElem = (currentPosition + i) % list.size()
            list[nextElem] = reversedSublist[i]
        }

    }

    static List<Integer> sublist(List<Integer> list, int length, int currentPosition) {
        int firstIndex = currentPosition
        int endIndex = (currentPosition + length) % list.size()

        if (firstIndex < endIndex) {
            return list[firstIndex..<endIndex]
        }
        list[firstIndex..<list.size()] + list[0..<endIndex]
    }
}
