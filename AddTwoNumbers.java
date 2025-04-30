import java.util.Arrays;

public class AddTwoNumbers {
  public static void main(String[] args) {
    int[] input = new int[] { 2, 7, 11, 15 };
    Solution s = new Solution();
    ListNode list1 = new ListNode(2, new ListNode(4, new ListNode(3)));
    ListNode list2 = new ListNode(5, new ListNode(6, new ListNode(4)));
    for(ListNode res = s.addTwoNumbers(list1, list2); res != null; res = res.next) {
      System.out.print(res.val + " ");
    }
  }
}

/*
 * Definition for singly-linked list.
 */
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
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode();
    ListNode copy = dummy;
    int carry = 0;
    for(; l1 != null || l2 != null;){
      int sum = 0;
      if(l1 != null){
        sum += l1.val;
        l1 = l1.next;
      }
      if(l2 != null){
        sum += l2.val;
        l2 = l2.next;
      }
      sum += carry;
      dummy.next = new ListNode(sum%10);
      dummy = dummy.next;
      carry = sum/10;
    }
    if(carry != 0) dummy.next = new ListNode(carry);
    return copy.next;
  }
}