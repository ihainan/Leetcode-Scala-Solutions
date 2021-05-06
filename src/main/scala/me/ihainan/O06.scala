package me.ihainan

object O06 {
  def reversePrint(head: ListNode): Array[Int] = {
    var len = 0
    var p = head
    while (p != null) {
      len += 1
      p = p.next
    }

    val ans = new Array[Int](len)
    p = head
    (len - 1 to 0 by -1).foreach { i =>
      ans(i) = p.x
      p = p.next
    }
    ans
  }
}