/**
 * Definition for singly-linked list.
 * class ListNode(var _x: Int = 0) {
 *   var next: ListNode = null
 *   var x: Int = _x
 * }
 */
object Solution {
  def removeDuplicateNodes(head: ListNode): ListNode = {
    val dummy = new ListNode(-1)
    dummy.next = head
    var p = dummy
    val set = collection.mutable.Set.empty[Int]
    while (p.next != null) {
      val x = p.next.x
      if (set(x)) p.next = p.next.next
      else {
        set += x
        p = p.next
      }
    }
    dummy.next
  }
}
