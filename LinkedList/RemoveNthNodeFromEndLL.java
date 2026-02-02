package LinkedList;
import structs.ListNode;

public class RemoveNthNodeFromEndLL {
  public static void main(String[] args) {
    ListNode ll = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
    new RemoveNthNodeFromEndLL().removeNthFromEnd(ll, 2);
    while(ll != null){
      System.out.print(ll.val + "->");
      ll = ll.next;
    }
    System.out.print("\n");
  }

  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummy = new ListNode(-1, head);
    ListNode slow = dummy, fast = dummy;
    for(int i = 0; i <= n; i+=1){
      fast = fast.next;
    }

    while(fast != null){
      slow = slow.next;
      fast = fast.next;
    }

    slow.next = slow.next.next;
    return dummy.next;
  }
}