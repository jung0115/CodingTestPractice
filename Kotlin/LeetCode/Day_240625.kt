// LeetCode - 24. Swap Nodes in Pairs
/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
  fun swapPairs(head: ListNode?): ListNode? {
    if (head == null || head.next == null) return head;
    var second = head.next;
    var third = second.next;

    second.next = head;
    head.next = swapPairs(third);

    return second;
  }
}