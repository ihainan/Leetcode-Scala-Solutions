package me.ihainan

object R1718 {
  def shortestSeq(big: Array[Int], small: Array[Int]): Array[Int] = {
    val map = small.zipWithIndex.toMap
    val indices = Array.fill(map.size)(List.empty[Int])
    big.indices.foreach { i =>
      val num = big(i);
      if (map.isDefinedAt(num)) indices(map(num)) = indices(map(num)) :+ i
    }

    if (indices.exists(_.isEmpty)) Array.empty[Int]
    else {
      val queue = collection.mutable.PriorityQueue.empty[Int](Ordering.Int.reverse)
      val current = Array.fill(map.size)(0) // current indices in the indices array
      var max = -1
      indices.map(_.head).foreach { index => max = max.max(index); queue.enqueue(index) }
      var ans = Int.MaxValue
      var (ansSmall, ansMax) = (-1, max)

      while (true) {
        val smallest = queue.dequeue
        if (max - smallest < ans) {
          ans = max - smallest
          ansSmall = smallest
          ansMax = max
        }
        val pos = map(big(smallest)) // get the index in the small array
        current(pos) += 1 // move forward
        if (current(pos) == indices(pos).length) return Array(ansSmall, ansMax)
        else {
          max = max.max(indices(pos)(current(pos)))
          queue.enqueue(indices(pos)(current(pos)))
        }
      }

      Array.empty[Int]
    }
  }
}