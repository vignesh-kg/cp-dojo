package cp.dojo.solution.linked.list;

import cp.dojo.structure.ListNode;

public class ReverseLL {

  public static void main(String[] args) {
    cp.dojo.solution.list.ReverseLL s = new cp.dojo.solution.list.ReverseLL();
    ListNode head = new ListNode(1, new ListNode(3, new ListNode(4)));
    ListNode newHead = s.reverseList(head);
    while (newHead != null) {
      System.out.print(newHead.val + " ");
      newHead = newHead.next;
    }
    System.out.print("\n");
  }

  public ListNode reverseList(ListNode head) {
    ListNode prev = null;
    for (ListNode temp = null; head != null; temp = head.next, head.next = prev, prev = head, head = temp)
      ;
    return prev;
  }
}