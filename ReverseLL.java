import structs.ListNode;

public class ReverseLL{
    public static void main(String[] args) {
        ListNode ll = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null))));
        ListNode reversed = new ReverseLL().reverseList(ll);
        while(reversed != null){
            System.out.print(reversed.val + "->");
            reversed = reversed.next;
        }
        System.out.print("\n");
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null, temp = null;
        while(head != null){
            temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
}