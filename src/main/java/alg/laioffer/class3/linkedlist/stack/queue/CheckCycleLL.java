package alg.laioffer.class3.linkedlist.stack.queue;

public class CheckCycleLL {
  public boolean hasCycle(ListNode head) {
    if (head == null || head.next == null) {
      return false;
    }
    ListNode slow = head;
    ListNode fast = head.next;
    while(fast != slow && fast.next != null && fast.next.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    if(fast == slow) {
      return true;
    }
    return false;
  }
}