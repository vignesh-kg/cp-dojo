package linkedlist;

import structs.ListNode;

public class MergeKSortedLists {
    public static void main(String[] args){
        MergeKSortedLists s = new MergeKSortedLists();
        ListNode head = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode head1 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode res = s.mergeKLists(new ListNode[]{head, head1});
        while(res != null){
            System.out.print(res.val + "->");
            res = res.next;
        }
        System.out.print("\n");
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(-1);
        ListNode copy = dummy;
        for(ListNode listNode : lists){
            dummy.next = listNode;
            while(dummy.next != null){
                dummy = dummy.next;
            }
        }
        return sort(copy.next);
    }

    private ListNode sort(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode middle = findMidNode(head);
        ListNode rightHalf = middle.next;
        middle.next = null;
        return merge(sort(head), sort(rightHalf));
    }

    private ListNode findMidNode(ListNode node){
        ListNode slow = node, fast = node.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode merge(ListNode head1, ListNode head2){
        ListNode dummy = new ListNode(-1);
        ListNode copy = dummy;
        while(head1 != null && head2 != null){
            if(head1.val < head2.val){
                dummy.next = head1;
                head1 = head1.next;
            } else {
                dummy.next = head2;
                head2 = head2.next;
            }
            dummy = dummy.next;
        }

        if(head1 != null){
            dummy.next = head1;
        } else {
            dummy.next = head2;
        }
        return copy.next;
    }
}
