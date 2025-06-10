package linkedlist;

import structs.ListNode;

public class MergeTwoSortedLists {
    public static void main(String[] args){
        MergeTwoSortedLists s = new MergeTwoSortedLists();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode head1 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode res = s.mergeTwoLists(head, head1);
        while(res != null){
            System.out.print(res.val + "->");
            res = res.next;
        }
        System.out.print("\n");
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode copy = dummy;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                dummy.next = list1;
                list1 = list1.next;
            } else {
                dummy.next = list2;
                list2 = list2.next;
            }
            dummy = dummy.next;
        }
        if(list1 != null){
            dummy.next = list1;
        } else {
            dummy.next = list2;
        }
        return copy.next;
    }
}
