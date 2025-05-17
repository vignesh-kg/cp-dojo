package cp.dojo.solution.linked.list;

import cp.dojo.structure.ListNode;

public class DeleteMiddleNodeOfLL {

  public static void main(String[] args) {
    DeleteMiddleNodeOfLL s = new DeleteMiddleNodeOfLL();
    ListNode head = new ListNode(1, new ListNode(3, new ListNode(4)));
    System.out.println("1 3 4");
    ListNode newHead = s.deleteMiddle(head);
    while (newHead != null) {
      System.out.print(newHead.val + " ");
      newHead = newHead.next;
    }
    System.out.print("\n");
  }

  public ListNode deleteMiddle(ListNode head) {
    if (head == null) {
      return head;
    }
    ListNode slow = head, fast = head;
    ListNode prev = slow;
    while (fast != null && fast.next != null) {
      prev = slow;
      slow = slow.next;
      fast = fast.next.next;
    }
    prev.next = slow.next;
    return head;
  }
}
