fun main() {
    test()
}

fun test() {
    println(usingTwoPointers(arrayOf(1, 2, 3, 4, 5), arrayOf(1, 2, 3)) == arrayOf(1, 2, 3).toList())
    println(usingTwoPointers(arrayOf(1, 2, 3, 4, 5), arrayOf(1, 2, 3)) == arrayOf(4, 5).toList())
    println(usingBinarySearch(arrayOf(1, 2, 3, 4, 5), arrayOf(1, 2, 3)) == arrayOf(1, 2, 3).toList())
    println(usingBinarySearch(arrayOf(1, 2, 3, 4, 5), arrayOf(1, 2, 3)) == arrayOf(4, 5).toList())
}

fun usingTwoPointers(array: Array<Int>, otherArray: Array<Int>): List<Int> {
    var pointer = 0
    var otherPointer = 0
    var commonElements = mutableListOf<Int>()
    while (pointer < array.size && otherPointer < otherArray.size) {
        if (array[pointer] == otherArray[otherPointer]) {
            commonElements.add(array[pointer])
            pointer++
            otherPointer++
        } else if (array[pointer] < otherArray[otherPointer]) pointer++
        else if (array[pointer] > otherArray[otherPointer]) otherPointer++
    }
    return commonElements
}

fun usingBinarySearch(array: Array<Int>, otherArray: Array<Int>): List<Int> = array.filter { otherArray.binarySearch(it) > -1 }
