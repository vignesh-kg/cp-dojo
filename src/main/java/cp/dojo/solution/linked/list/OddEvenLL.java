package cp.dojo.solution.linked.list;

import cp.dojo.structure.ListNode;

public class OddEvenLL {

  public static void main(String[] args) {
    cp.dojo.solution.list.OddEvenLL s = new cp.dojo.solution.list.OddEvenLL();
    ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
    ListNode newHead = s.oddEvenList(head);
    while (newHead != null) {
      System.out.print(newHead.val + " ");
      newHead = newHead.next;
    }
    System.out.print("\n");
  }

  public ListNode oddEvenList(ListNode head) {
    if(head == null || head.next == null)
      return head;
    /*
     * 1 -> 2 -> 3 -> 4 -> 5 -> null
     * OddNode = 1, evenNode = 2, evenHead = 2
     * while(2.next != null) 1 -> 3; oddNode = 3; 2 -> 4
     * 
    */
    ListNode oddNode = head, evenNode = head.next, evenHead = evenNode;
    while(evenNode != null && evenNode.next != null){
      oddNode.next = evenNode.next;
      oddNode = oddNode.next;
      evenNode.next = oddNode.next;
      evenNode = evenNode.next;
    }
    oddNode.next = evenHead;
    return head;
  }
}