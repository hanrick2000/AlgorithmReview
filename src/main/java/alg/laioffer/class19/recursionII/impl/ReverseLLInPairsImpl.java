package alg.laioffer.class19.recursionII.impl;

import alg.laioffer.class19.recursionII.ReverseLLInPairs;
import alg.laioffer.class4.linkedlist.ListNode;

/**
 * Aug 28
 */
public class ReverseLLInPairsImpl implements ReverseLLInPairs {
  @Override
  public ListNode reverseInPairs(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode headOfRest = reverseInPairs(head.next.next);
    ListNode newHead = head.next; // don't lose head
    newHead.next = head;
    head.next = headOfRest;
    return newHead;
  }
}
