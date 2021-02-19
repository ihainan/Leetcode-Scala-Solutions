/**
 * Definition for singly-linked list.
 * class ListNode(var _x: Int = 0) {
 *   var next: ListNode = null
 *   var x: Int = _x
 * }
 */
object Solution {
  def findMid(head: ListNode): ListNode = {
    if (head == null || head.next == null) head
    else {
      var (p, q) = (head, head.next)
      while (q != null && q.next != null) {
        p = p.next
        q = q.next.next
      }    
      p
    }
  }

  def reverse(head: ListNode): ListNode = {
    if (head == null || head.next == null) head
    else {
      var cur = head
      var prev: ListNode = null
      while (cur != null) {
        val next = cur.next
        cur.next = prev
        prev = cur
        cur = next
      }
      prev
    }
  }

  def isPalindrome(head: ListNode): Boolean = {
    if (head == null || head.next == null) true
    else {
      val mid = findMid(head)
      val next = mid.next
      mid.next = null
      val reversed = reverse(next)
      var (p, q) = (head, reversed)
      while (q != null && p != null) {
        if (p.x != q.x) return false
        p = p.next
        q = q.next
      }
      true
    }
  }
}
