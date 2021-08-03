package me.ihainan

object P369 {
  def plusOne(head: ListNode): ListNode = {

    def addOne(node: ListNode): Int = {
      val sum = if (node.next == null) node.x + 1 else node.x + addOne(node.next)
      node.x = sum % 10
      sum / 10
    }

    if (addOne(head) == 0) head
    else {
      val newHead = new ListNode(1)
      newHead.next = head
      newHead
    }

  }
}