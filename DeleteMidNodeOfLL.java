public class DeleteMidNodeOfLL {
  public static void main(String[] args){
    Solution s = new Solution();
    ListNode head = new ListNode(1, new ListNode(3, new ListNode(4)));
    ListNode newHead = s.deleteMiddle(head);
    while(newHead != null){
      System.out.print(newHead.val + " ");
      newHead = newHead.next;
    }
    System.out.print("\n");
  }
}

class ListNode {
  int val;
  ListNode next;

  ListNode() {
  }

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}

class Solution {
  public ListNode deleteMiddle(ListNode head) {
    if(head == null || head.next == null) return null;
    ListNode copy = head;
    ListNode slow = head, fast = head;
    ListNode prev = slow;
    while(fast != null && fast.next != null ){
      prev = slow;
      slow = slow.next;
      fast = fast.next.next;
    }
    prev.next = prev.next.next;

    return copy;
  }
}