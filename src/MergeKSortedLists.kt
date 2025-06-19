import structs.ListNode

fun main() {
    val l1: ListNode = ListNode(1, ListNode(4, ListNode(5)))
    val l2: ListNode = ListNode(1, ListNode(3, ListNode(4)))
    val l3: ListNode = ListNode(2, ListNode(6))
    var head: ListNode? = mergeKLists(arrayOf(l1, l2, l3))
    while (head != null) {
        print("${head.`val`} ")
        head = head.next
    }
    print("\n")
}

fun mergeKLists(lists: Array<ListNode?>): ListNode? {
    var dummy: ListNode? = ListNode(-1)
    val copy: ListNode? = dummy
    for (node in lists) {
        dummy?.next = node
        while (dummy?.next != null) {
            dummy = dummy.next
        }
    }
    return sort(copy?.next)
}

fun sort(node: ListNode?): ListNode? {
    if (node == null || node.next == null) {
        return node
    }

    val midNode: ListNode? = findMidNode(node)
    val right: ListNode? = midNode?.next
    midNode?.next = null
    return merge(sort(node), sort(right))
}

fun merge(l1: ListNode?, l2: ListNode?): ListNode? {
    var dummy: ListNode? = ListNode(-1)
    val copy: ListNode? = dummy
    var h1: ListNode? = l1
    var h2: ListNode? = l2
    while (h1 != null && h2 != null) {
        if (h1.`val` < h2.`val`) {
            dummy?.next = h1
            h1 = h1.next
        } else {
            dummy?.next = h2
            h2 = h2.next
        }
        dummy = dummy?.next
    }
    if (h1 != null) {
        dummy?.next = h1
    } else {
        dummy?.next = h2
    }
    return copy?.next
}

fun findMidNode(node: ListNode?): ListNode? {
    if (node == null || node.next == null) {
        return node
    }

    var slow: ListNode? = node
    var fast: ListNode? = node.next
    while (fast != null && fast.next != null) {
        slow = slow?.next
        fast = fast.next?.next
    }
    return slow
}