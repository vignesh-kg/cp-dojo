package structs;

public class ListNode {
  public int val;
  public ListNode next;
  public ListNode child;

  public ListNode() {
  }

  public ListNode(int val) {
    this.val = val;
  }

  public ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }

  public ListNode(int val, ListNode next, ListNode child) {
    this.val = val;
    this.next = next;
    this.child = child;
  }

  public static void print(ListNode head){
    while(head != null){
      if(head.next != null){
        System.out.print(head.val + " -> ");
      } else {
        System.out.println(head.val);
      }
    }
  }
}
