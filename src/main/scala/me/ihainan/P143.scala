package me.ihainan

object P143 {
  def reorderList(head: ListNode): Unit = {
    if (head != null) {
      val nodes = collection.mutable.ArrayBuffer.empty[ListNode]
      var p = head
      while (p != null) {
        nodes += p
        p = p.next
      }
      val dummy = new ListNode(0)
      p = dummy
      var (i, j) = (0, nodes.length - 1)
      while (i <= j) {
        nodes(i).next = nodes(j)
        nodes(j).next = null
        p.next = nodes(i)
        p = nodes(j)
        i += 1
        j -= 1
      }
    }
  }
}
