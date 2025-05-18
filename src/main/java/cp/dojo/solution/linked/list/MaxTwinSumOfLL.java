package cp.dojo.solution.linked.list;

import cp.dojo.structure.ListNode;

public class MaxTwinSumOfLL {

  public static void main(String[] args) {
    ListNode head = new ListNode(4, new ListNode(2, new ListNode(2, new ListNode(3))));
    System.out.print(new cp.dojo.solution.list.MaxTwinSumOfLL().pairSum(head));
  }

  public int pairSum(ListNode head) {
    /*
     * 4 -> 2 -> 2 -> 3 -> null
     */
    // Find mid Node
    ListNode slow = head, fast = head;
    for (; fast != null && fast.next != null; slow = slow.next, fast = fast.next.next) ;

    // slow is mid node
    // Reverse list from slow
    ListNode prev = null;
    while (slow != null) {
      ListNode temp = slow.next;
      slow.next = prev;
      prev = slow;
      slow = temp;
    }
    /*
     * head = 4 -> 2 prev = 3 -> 2
     */
    int maxSum = Integer.MIN_VALUE;
    while (prev != null) {
      if (prev.val + head.val > maxSum) {
        maxSum = prev.val + head.val;
      }
      prev = prev.next;
      head = head.next;
    }
    return maxSum;
  }
}
