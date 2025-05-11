public class ReverseLL {

  public static void main(String[] args) {
    Solution s = new Solution();
    ListNode head = new ListNode(1, new ListNode(3, new ListNode(4)));
    ListNode newHead = s.reverseList(head);
    while (newHead != null) {
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
  @SuppressWarnings("empty-statement")
  public ListNode reverseList(ListNode head) {
    ListNode prev = null;
    for (ListNode temp = null; head != null; temp = head.next, head.next = prev, prev = head, head = temp)
      ;
    return prev;
  }
}