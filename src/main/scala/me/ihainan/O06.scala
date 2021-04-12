package me.ihainan

object O06 {
  def reversePrint(head: ListNode): Array[Int] = {
    if (head == null) Array.empty[Int]
    else {
      var p = head
      var len = 0
      while (p != null) {
        p = p.next
        len += 1
      }

      val ans = new Array[Int](len)
      p = head
      (ans.length - 1 to 0 by -1).foreach { i =>
        ans(i) = p.x
        p = p.next
      }
      ans
    }
  }
}