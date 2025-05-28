package cp.dojo.solution.linked.list;

import cp.dojo.structure.ListNode;

public class MergeKSortedLists {
  public static void main(String[] args){
    MergeKSortedLists s = new MergeKSortedLists();
    ListNode l1 = new ListNode(1, new ListNode(4, new ListNode(5)));
    ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
    ListNode l3 = new ListNode(2, new ListNode(6));
    ListNode sortedHead = s.mergeKLists(new ListNode[]{l1, l2, l3});
    while(sortedHead != null){
      System.out.print(sortedHead.val + " ");
      sortedHead = sortedHead.next;
    }
    System.out.print("\n");
  }

  public ListNode mergeKLists(ListNode[] lists) {
    ListNode dummyHead = new ListNode(-1);
    ListNode temp = dummyHead;
    for(ListNode list : lists){
      dummyHead.next = list;
      while(dummyHead.next != null){
        dummyHead = dummyHead.next;
      }
    }
    return sort(temp.next);
  }

  private ListNode sort(ListNode head){
    if(head == null || head.next == null){
      return head;
    }
    ListNode mid = findMidNode(head);
    ListNode right = mid.next;
    mid.next = null;
    ListNode left = head;
    return merge(sort(left), sort(right));
  }

  private ListNode merge(ListNode l1, ListNode l2){
    ListNode dummy = new ListNode(-1, null);
    ListNode temp = dummy;
    while(l1 != null && l2 != null){
      if(l1.val <= l2.val){
        dummy.next = l1;
        l1 = l1.next;
      } else {
        dummy.next = l2;
        l2 = l2.next;
      }
      dummy = dummy.next;
    }
    if(l1 != null){
      dummy.next = l1;
    } else {
      dummy.next = l2;
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
