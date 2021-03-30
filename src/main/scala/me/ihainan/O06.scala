package me.ihainan

object O06 {

  def reversePrint(head: ListNode): Array[Int] = {
    var len = 0
    var current = head
    while (current != null) {
      current = current.next
      len += 1
    }

    if (len == 0) Array.empty[Int]
    else {
      val ans = new Array[Int](len)
      var i = ans.length - 1
      current = head
      while (current != null) {
        ans(i) = current.x
        i -= 1
        current = current.next
      }
      ans
    }
  }
}