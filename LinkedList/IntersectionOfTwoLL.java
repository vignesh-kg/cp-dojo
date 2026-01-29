package LinkedList;
import structs.ListNode;

public class IntersectionOfTwoLL {
    public static void main(String[] args){
        ListNode intersect = new ListNode(8, new ListNode(4, new ListNode(5)));
        ListNode headA = new ListNode(4, new ListNode(1, intersect));
        ListNode headB = new ListNode(5, new ListNode(6, new ListNode(1, intersect)));
        System.out.println(new IntersectionOfTwoLL().getIntersectionNode(headA, headB).val);
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp1 = headA, temp2 = headB;
        while(temp1 != temp2){
            temp1 = temp1 == null ? headB : temp1.next;
            temp2 = temp2 == null ? headA : temp2.next;
        }
        return temp1;
    }
}
