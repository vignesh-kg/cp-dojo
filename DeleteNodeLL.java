import structs.ListNode;

public class DeleteNodeLL {
    public static void main(String[] args){
        ListNode end = new ListNode(4);
        ListNode third = new ListNode(3, end);
        ListNode head = new ListNode(1, new ListNode(2, third));

        new DeleteNodeLL().deleteNode(third);
        while(third != null){
            System.out.print(third.val + "->");
            third = third.next;
        }
        System.out.print("\n");
    }

    public void deleteNode(ListNode node) {
        ListNode prev = node;
        while(node != null && node.next != null){
            node.val = node.next.val;
            prev = node;
            node = node.next;
        }
        prev.next = null;
    }
}
