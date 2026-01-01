import structs.ListNode;

public class AddTwoNumbers {
  public static void main(String[] args) {
    AddTwoNumbers s = new AddTwoNumbers();
    ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
    ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

    ListNode result = s.addTwoNumbers(l1, l2);
    while(result != null){
      System.out.print(result.val + "->");
      result = result.next;
    }
    System.out.print("\n");
  }

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(-1);
    ListNode copy = dummy;
    int carry = 0;
    while (l1 != null || l2 != null) {
      int sum = 0;
      if (l1 != null) {
        sum += l1.val;
        l1 = l1.next;
      }

      if (l2 != null) {
        sum += l2.val;
        l2 = l2.next;
      }

      sum += carry;
      copy.next = new ListNode(sum % 10);
      copy = copy.next;

      carry = sum / 10;
    }
    if (carry != 0) {
      copy.next = new ListNode(carry);
    }
    return dummy.next;
  }
}
