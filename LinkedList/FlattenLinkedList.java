package LinkedList;

import structs.ListNode;

public class FlattenLinkedList {
    public static void main(String[] args) {
        ListNode next3 = new ListNode(4, null, new ListNode(9));
        ListNode next2 = new ListNode(1, next3, new ListNode(7, null, new ListNode(11, null, new ListNode(12))));
        ListNode next1 = new ListNode(2, next2, new ListNode(10));
        ListNode head = new ListNode(3, next1);

        ListNode res = new FlattenLinkedList().flattenLinkedList(head);
        while(res != null){
            System.out.print(res.val + " -> ");
            res = res.child;
        }
        System.out.print("\n");
    }

    public ListNode flattenLinkedList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode mergedHead = flattenLinkedList(head.next);
        return merge(head, mergedHead);
    }

    private ListNode merge(ListNode a, ListNode b){
        ListNode dummy = new ListNode(-1);
        ListNode copy = dummy;
        while(a != null && b != null){
            if(a.val <= b.val){
                dummy.child = a;
                a = a.child;
            } else {
                dummy.child = b;
                b = b.child;
            }
            dummy = dummy.child;
        }
        if(a == null){
            dummy.child = b;
        } else {
            dummy.child = a;
        }
        return copy.child;
    }
}
