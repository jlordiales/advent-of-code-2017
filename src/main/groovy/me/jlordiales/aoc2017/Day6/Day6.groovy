package me.jlordiales.aoc2017.Day6

class Day6 {

    static def redistributionStates(List<Integer> memoryBanks) {
        def states = [memoryBanks.hashCode()]
        def next = nextState(memoryBanks)
        while (!states.contains(next.hashCode())) {
            states << next.hashCode()
            next = nextState(memoryBanks)
        }
        states
    }

    static def nextState(List<Integer> memoryBanks) {
        int memoryBankIndex = findMemoryBankWithMostBlocks(memoryBanks)
        int blocksToDistribute = memoryBanks[memoryBankIndex]
        memoryBanks[memoryBankIndex] = 0
        distributeBlocks(blocksToDistribute, memoryBanks, (memoryBankIndex + 1) % memoryBanks.size())
        memoryBanks
    }

    static void distributeBlocks(int blocksToDistribute, List<Integer> memoryBanks, int startingIndex) {
        int index = startingIndex
        int numberOfMemoryBanks = memoryBanks.size()
        blocksToDistribute.times {
            memoryBanks[index % numberOfMemoryBanks]++
            index++
        }
    }

    static int findMemoryBankWithMostBlocks(List<Integer> memoryBanks) {
        int maxBlocks = memoryBanks.max()
        memoryBanks.findIndexOf { it == maxBlocks }
    }
}
