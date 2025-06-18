import structs.ListNode

fun main(){
    val l1 : ListNode? = ListNode(2, ListNode(4, ListNode(3, null)))
    val l2 : ListNode? = ListNode(5, ListNode(6, ListNode(4, null)))
    var res = addTwoNumbers(l1, l2)
    while(res != null){
        print("${res.`val`} ")
        res = res.next
    }
    print("\n")
}

fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    var dummy : ListNode? = ListNode(-1, null)
    val copy = dummy
    var carry : Int = 0
    var h1 = l1;
    var h2 = l2
    while(h1 != null || h2 != null){
        var sum = 0
        if(h1 != null){
            sum += h1.`val`
            h1 = h1.next
        }
        if(h2 != null){
            sum += h2.`val`
            h2 = h2.next
        }
        sum += carry
        dummy?.next = ListNode(sum%10)
        dummy = dummy?.next
        carry = sum/10
    }
    if(carry != 0){
        dummy?.next = ListNode(carry)
    }
    return copy?.next
}