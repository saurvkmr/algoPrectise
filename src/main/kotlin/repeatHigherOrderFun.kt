fun main() {
    repeat(100) { print(".") }
}

fun repeat(times: Int, action: () -> Unit) {
    for (i in 0 until times)
        action()
}
