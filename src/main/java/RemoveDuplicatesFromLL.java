import structs.ListNode;

public class RemoveDuplicatesFromLL {
  public static void main(String[] args){
    RemoveDuplicatesFromLL s = new RemoveDuplicatesFromLL();
    ListNode head = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(2))));
    ListNode res = s.deleteDuplicates(head);
    while(res != null){
      System.out.print(res.val + " ");
      res = res.next;
    }
    System.out.print("\n");
    head = new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(2))));
    res = s.deleteDuplicates(head);
    while(res != null){
      System.out.print(res.val + " ");
      res = res.next;
    }
    System.out.print("\n");
  }

  public ListNode deleteDuplicates(ListNode head) {
    ListNode copy = head;
    while(copy != null && copy.next != null){
      while(copy.val == copy.next.val){
        copy.next = copy.next.next;
      }
      copy = copy.next;
    }
    return head;
  }
}
