
/**
 * 1. create a sliding window for size of permutationOf
 * 2. check if all the alphabets of permutationOf are present in permutationIn
 * 3. check if the count of each alphabet is same
 */
fun main() {
    // validateCreateMapOfAlphabetCount()
    validateFindPermutationOfStringInAnotherString()
}

fun findPermutationOfStringInAnotherString(permutationOf: String, permutationIn: String): String {
    var result = "Not found"
    if (permutationOf.length > permutationIn.length) return result
    val alphabetCountMapOfStrToFind = createMapOfAlphabetCount(permutationOf)
    if (compareStringUsingSlidingWindowWithoutRecursion(alphabetCountMapOfStrToFind, permutationIn, permutationOf.length))
        result = "Found"
    return result
}

fun findPermutationOfStringInAnotherStringUsingRecursion(permutationOf: String, permutationIn: String): String {
    var result = "Not found"
    if (permutationOf.length > permutationIn.length) return result
    val alphabetCountMapOfStrToFind = createMapOfAlphabetCount(permutationOf)
    var left = 0
    var right = permutationOf.length
    if (compareStringUsingSlidingWindowWithRecursion(alphabetCountMapOfStrToFind, permutationIn, left, right, permutationOf.length))
        result = "Found"
    return result
}

fun createMapOfAlphabetCount(inputString: String): Map<Char, Int> {
    val mapOfAlphabetCount = mutableMapOf<Char, Int>()
    inputString.forEach { alphabet ->
        mapOfAlphabetCount[alphabet] = mapOfAlphabetCount.getOrDefault(alphabet, 0) + 1
    }
    return mapOfAlphabetCount
}

fun compareStringUsingSlidingWindowWithRecursion(alphabetCountMapOfStrToFind: Map<Char, Int>, permutationIn: String, startIndex: Int, endIndex: Int, stringLen: Int): Boolean {
    if (endIndex > permutationIn.length) return false
    val actualMap = with(permutationIn.substring(startIndex, endIndex)) { createMapOfAlphabetCount(this) }
    if (alphabetCountMapOfStrToFind == actualMap) return true
    return compareStringUsingSlidingWindowWithRecursion(alphabetCountMapOfStrToFind, permutationIn, startIndex+1, endIndex+1, stringLen)
}

fun compareStringUsingSlidingWindowWithoutRecursion(alphabetCountMapOfStrToFind: Map<Char, Int>, permutationIn: String, stringLen: Int): Boolean {
    var left = 0
    var right = stringLen
    while(right <= permutationIn.length) {
        val substring = permutationIn.substring(left, right)
        val actualMap = createMapOfAlphabetCount(substring)
        if (alphabetCountMapOfStrToFind == actualMap) return true
        left++
        right++
    }
    return false
}

fun validateCreateMapOfAlphabetCount() {
    println(createMapOfAlphabetCount("aaa") == mapOf('a' to 3))
    println(createMapOfAlphabetCount("aaa") == mapOf('a' to 2))
}

fun validateFindPermutationOfStringInAnotherString() {
    println(findPermutationOfStringInAnotherString("aa", "aaa") == "Found")
    println(findPermutationOfStringInAnotherString("aa", "abc") == "Not found")
    println(findPermutationOfStringInAnotherString("abc", "acb") == "Found")
    println(findPermutationOfStringInAnotherString("abc", "adefacb") == "Found")
    println(findPermutationOfStringInAnotherString("abc", "acdefafcb") == "Not found")
    println(findPermutationOfStringInAnotherString("abc", "ac") == "Not found")

    println(findPermutationOfStringInAnotherStringUsingRecursion("aa", "aaa") == "Found")
    println(findPermutationOfStringInAnotherStringUsingRecursion("aa", "abc") == "Not found")
    println(findPermutationOfStringInAnotherStringUsingRecursion("abc", "acb") == "Found")
    println(findPermutationOfStringInAnotherStringUsingRecursion("abc", "adefacb") == "Found")
    println(findPermutationOfStringInAnotherStringUsingRecursion("abc", "acdefafcb") == "Not found")
    println(findPermutationOfStringInAnotherStringUsingRecursion("abc", "ac") == "Not found")
}

