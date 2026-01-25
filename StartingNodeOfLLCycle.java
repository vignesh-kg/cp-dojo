import structs.ListNode;

public class StartingNodeOfLLCycle {
    public static void main(String[] args) {
        ListNode node2 = new ListNode(2);
        ListNode head = new ListNode(3, node2);
        node2.next = new ListNode(0, new ListNode(4, node2));

        ListNode loopStart = new StartingNodeOfLLCycle().detectCycle(head);
        System.out.println(loopStart.val);
    }

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        boolean isCycleExist = false;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                isCycleExist = true;
                break;
            }
        }
        if(isCycleExist){
            slow = head;
            while(slow != fast){
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }
        return null;
    }
}
