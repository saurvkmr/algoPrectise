import kotlin.math.abs

// Check if two strings are one altercation (one replace, one remove, one insert) away

fun main() {
    println(checkIfOneEditAway("pale", "baale"))
}

fun checkIfOneEditAway(first: String, second: String): Boolean {
    var firstIndex = 0
    var secondIndex = 0
    var isOneEditAway = true
    var editCount = 0
    while (isOneEditAway && firstIndex < first.length && secondIndex < second.length) {
        if (first[firstIndex] == second[secondIndex]) {
            firstIndex++
            secondIndex++
        } else {
            if (editCount == 1) {
                isOneEditAway = false
            }
            editCount++
            if (first.length > second.length) {
                firstIndex++
            } else if (second.length > first.length) {
                secondIndex++
            } else {
                firstIndex++
                secondIndex++
            }
        }
    }
    if (editCount == 0 && abs(second.length - first.length) > 1) {
        isOneEditAway = false
    } else if (editCount > 1) {
        isOneEditAway = false
    }
    return isOneEditAway
}
