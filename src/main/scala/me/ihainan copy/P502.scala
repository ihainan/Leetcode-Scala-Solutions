package me.ihainan

object P502 {
  def findMaximizedCapital(
      k: Int,
      w: Int,
      profits: Array[Int],
      capital: Array[Int]
  ): Int = {
    val sorted = profits.indices
      .map(i => (capital(i), profits(i)))
      .sorted(Ordering.by[(Int, Int), Int](v => v._1))
    val queue = collection.mutable.PriorityQueue.empty[Int]
    var cur = 0
    var ans = w
    (0 until k).foreach { _ =>
      while (cur < sorted.length && sorted(cur)._1 <= ans) {
        queue.enqueue(sorted(cur)._2)
        cur += 1
      }
      if (queue.nonEmpty) ans += queue.dequeue()
      else return ans
    }
    ans
  }
}
