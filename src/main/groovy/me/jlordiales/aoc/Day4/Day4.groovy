package me.jlordiales.aoc.Day4

class Day4 {

    static int numberOfValidPassphrases(String input, Closure<Boolean> validator) {
        input.readLines().findAll(validator).size()
    }

    static Closure<Boolean> firstHalfValidator() {
        { passphrase -> isValid(passphrase) }
    }

    static Closure<Boolean> secondHalfValidator() {
        { passphrase -> isValid2(passphrase) }
    }

    static boolean isValid(String passphrase) {
        isValid(passphrase, { it })
    }

    static boolean isValid2(String passphrase) {
        isValid(passphrase, { wordList -> wordList.collect { sortChars(it) } })
    }

    static boolean isValid(String passphrase, Closure<Boolean> processWordList) {
        def wordList = passphrase.split(" ")
        def processedWordList = processWordList(wordList)
        processedWordList.size() == (processedWordList as Set).size()
    }

    static def sortChars(String s) {
        s.toCharArray().collect().sort().join("")
    }
}
