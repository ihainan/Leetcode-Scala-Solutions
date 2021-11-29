package me.ihainan

object P23 {
  def mergeKLists(lists: Array[ListNode]): ListNode = {
    val ordering = Ordering.by[ListNode, Int](node => -node.x)
    val queue = collection.mutable.PriorityQueue.empty[ListNode](ordering)
    val dummy = new ListNode(0, null)
    var p = dummy
    lists.foreach(list => if (list != null) queue.enqueue(list))
    while (queue.nonEmpty) {
      val next = queue.dequeue
      p.next = next
      if (next.next != null) queue.enqueue(next.next)
      p = p.next
    }
    dummy.next
  }
}
