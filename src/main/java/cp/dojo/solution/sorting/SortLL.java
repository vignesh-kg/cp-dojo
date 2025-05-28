package cp.dojo.solution.sorting;

import cp.dojo.structure.ListNode;

public class SortLL {
  public static void main(String[] args){
    SortLL s = new SortLL();
    ListNode head = new ListNode(10, new ListNode(99, new ListNode(7, new ListNode(63))));
    ListNode sortedHead = s.sort(head);
    while(sortedHead != null){
      System.out.print(sortedHead.val + " ");
      sortedHead = sortedHead.next;
    }
    System.out.print("\n");
  }

  public ListNode sort(ListNode head){
    if(head == null || head.next == null){
      return head;
    }

    ListNode mid = findMidNode(head);
    ListNode right = mid.next;
    mid.next = null;
    ListNode left = head;

    return merge(sort(left), sort(right));
  }

  private ListNode merge(ListNode left, ListNode right){
    ListNode dummy = new ListNode(-1, null);
    ListNode temp = dummy;
    while(left != null && right != null){
      if(left.val <= right.val){
        dummy.next = left;
        left = left.next;
      } else {
        dummy.next = right;
        right = right.next;
      }
      dummy = dummy.next;
    }
    if(left != null){
      dummy.next = left;
    } else {
      dummy.next = right;
    }
    return temp.next;
  }

  private ListNode findMidNode(ListNode node){
    if(node == null || node.next == null){
      return node;
    }

    ListNode slow = node;
    ListNode fast = node.next;
    while(fast != null && fast.next != null){
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }
}
