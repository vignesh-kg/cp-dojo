import structs.ListNode;

public class LLCycle {
  public static void main(String[] args){
    LLCycle s = new LLCycle();
    ListNode node2 = new ListNode(2);
    ListNode head = new ListNode(3, node2);
    node2.next = new ListNode(0, new ListNode(4, node2));
    System.out.println(s.hasCycle(head));
  }

  public boolean hasCycle(ListNode head) {
    ListNode slow = head, fast = head;
    while(fast != null && fast.next != null){
      slow = slow.next;
      fast = fast.next.next;
      if(slow == fast){
        return true;
      }
    }
    return false;
  }
}
