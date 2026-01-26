import java.util.function.BiFunction;
import java.util.function.Function;

import structs.ListNode;

public class ReverseNodesInKGroup {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode reversed = new ReverseNodesInKGroup().reverseKGroup(head, 2);
        while(reversed != null){
            System.out.print(reversed.val + " -> ");
            reversed = reversed.next;
        }
        System.out.println("\n");
    }
    private static ListNode reverseNode(ListNode node) {
        ListNode prev = null, temp = null;
        while(node != null){
            temp = node.next;
            node.next = prev;
            prev = node;
            node = temp;
        }
        return prev;
    }
    private static ListNode findKthNode(ListNode node, int k) {
        while(k-- > 1 && node != null){
            node = node.next;
        }
        return node;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode kthListNode = new ListNode();
        ListNode dummyListNode = new ListNode(-1);
        ListNode copyListNode = dummyListNode;
        while(kthListNode != null){
            kthListNode = findKthNode(head, k);
            if(kthListNode != null){
                ListNode nextHead = kthListNode.next;
                kthListNode.next = null;
                dummyListNode.next = reverseNode(head);
                dummyListNode = head;
                head = nextHead;
            } else {
                dummyListNode.next = head;
            }
        }
        return copyListNode.next;
    }
}
