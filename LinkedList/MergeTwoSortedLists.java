package LinkedList;

import structs.ListNode;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode copy = dummy;
        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
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

    public static void main(String[] args) {
        ListNode.print(new MergeTwoSortedLists().mergeTwoLists(ListNode.createLL(new int[] { 1, 2, 4 }),
                ListNode.createLL(new int[] { 1, 3, 4 })));
    }
}
