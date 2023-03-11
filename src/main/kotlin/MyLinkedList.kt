class MyLinkedList<T> {
    private var head: Node<T>? = null
    private var length: Long = 0

    constructor() {}

    constructor(item: T) {
        add(item)
    }

    inner class Node<T>(
        val item: T,
        var next: Node<T>? = null
    )

    fun add(item: T): MyLinkedList<T> {
        val node = Node(item)
        if (head == null)
            head = node
        else addNodeInTheEnd(node)
        length++
        return this
    }

    private fun addNodeInTheEnd(node: Node<T>): MyLinkedList<T> {
        var temp = head
        while (temp?.next != null) {
            temp = temp.next
        }
        temp?.next = node
        return this
    }

    fun addAll(vararg items: T): MyLinkedList<T> {
        items.forEach { add(it) }
        return this
    }

    fun size(): Long = length

    fun isEmpty(): Boolean = length == 0L

    override fun toString(): String {
        var temp = head
        var output = StringBuilder()
        while (temp != null) {
            with(output) {
                append(temp!!.item.toString())
                append(" ")
            }
            temp = temp.next
        }
        return output.toString().trim()
    }
}
