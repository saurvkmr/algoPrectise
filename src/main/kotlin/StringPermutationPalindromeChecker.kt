/**
 * A permutation of a string can be palindrome that means that the
 * 1. call chars of string have even number of appearance
 * 2. or at most one char is of add count and rest all have evens counts
 * If there are two odd count chars then string is no palindrome.
 */
fun main() {
    println(isPermutationPalindrome("a"))
    println(isPermutationPalindrome("ab"))
    println(isPermutationPalindrome("aba"))
    println(isPermutationPalindrome("aabbb"))
    println(isPermutationPalindrome("aabcbb"))
}

fun isPermutationPalindrome(input: String): Boolean {
    val charCount = mutableMapOf<Char, Int>()
    input.forEach { charCount[it] = charCount.getOrDefault(it, 0) + 1 }
    return charCount.entries.count { it.value % 2 != 0} <= 1
}

