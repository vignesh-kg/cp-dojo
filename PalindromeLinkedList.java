import java.util.function.Function;

import structs.ListNode;

public class PalindromeLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));
        System.out.println(new PalindromeLinkedList().isPalindrome(head));
        head = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(3))));
        System.out.println(new PalindromeLinkedList().isPalindrome(head));
        head = new ListNode(1, new ListNode(2));
        System.out.println(new PalindromeLinkedList().isPalindrome(head));
    }

    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }

        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode midNode = slow;
        ListNode copy = midNode;
        ListNode prev = null, nextNode = null;
        while(midNode != null){
            nextNode = midNode.next;
            midNode.next = prev;
            prev = midNode;
            midNode = nextNode;
        }
        midNode = prev;
        while(head != null && midNode != null){
            if(head.val != midNode.val){
                return false;
            }
            head = head.next;
            midNode = midNode.next;
        }
        return true;
    }
}
