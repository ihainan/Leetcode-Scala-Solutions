package me.ihainan

object P358 {
  def rearrangeString(s: String, k: Int): String = {
    if (k == 0) return s
    val ans = new StringBuilder()
    val last = Array.fill(26)(-1)
    val ordering = new Ordering[(Char, Int)] {
      def compare(v1: (Char, Int), v2: (Char, Int)): Int = {
        if (v1._2 != v2._2) v1._2 - v2._2
        else v2._1 - v1._1
      }
    }
    val queue = collection.mutable.PriorityQueue.empty[(Char, Int)](ordering)
    val times = new Array[Int](26)
    s.foreach { c => times(c - 'a') += 1 }
    (0 until 26).foreach { i => if (times(i) > 0) queue.enqueue((('a' + i).toChar, times(i))) }

    var i = 0
    while (ans.length != s.length) {
      val toAdd = collection.mutable.ArrayBuffer.empty[(Char, Int)]
      (i until (i + k).min(s.length)).foreach { j =>
        if (queue.isEmpty) return ""
        val (c, count) = queue.dequeue
        val lastPos = last(c - 'a')
        println(c, count, j, lastPos)
        if (lastPos != -1 && j - lastPos < k) return ""
        else {
          last(c - 'a') = j
          ans.append(c)
          if (count > 1) toAdd += ((c, count - 1))
        }
      }

      toAdd.foreach { case (c, count) => queue.enqueue((c, count)) }
      i += k
    }

    ans.toString
  }
}