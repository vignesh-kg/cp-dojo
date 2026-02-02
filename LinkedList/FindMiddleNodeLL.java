package LinkedList;
import structs.ListNode;

public class FindMiddleNodeLL {
    public static void main(String[] args){
        ListNode ll = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null))));
        ListNode mid = new FindMiddleNodeLL().middleNode(ll);
        while(mid != null){
            System.out.print(mid.val + "->");
            mid = mid.next;
        }
        System.out.print("\n");
    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
