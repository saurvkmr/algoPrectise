import kotlin.math.abs

// Check if two strings are one altercation (one replace, one remove, one insert) away

fun main() {
    println(checkIfOneEditAway("pale", "baale"))
    println(checkIfOneEditAway("apple", "aple"))
}

fun checkIfOneEditAway(first: String, second: String): Boolean {
    if (abs(second.length - first.length) > 1)
        return false

    var firstIndex = 0
    var secondIndex = 0
    var foundDifference = false
    while (firstIndex < first.length && secondIndex < second.length) {
        if (first[firstIndex] == second[secondIndex]) {
            firstIndex++
            secondIndex++
        } else {
            if (foundDifference) return false
            foundDifference = true
            if (first.length > second.length) firstIndex++
            else if (second.length > first.length) secondIndex++
            else {
                firstIndex++
                secondIndex++
            }
        }
    }
    return true
}
