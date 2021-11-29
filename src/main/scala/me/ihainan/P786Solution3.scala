package me.ihainan

object P786Solution3 {
  def kthSmallestPrimeFraction(arr: Array[Int], k: Int): Array[Int] = {
    val ordering =
      Ordering.by[Array[Int], Double](v => -arr(v(0)) * 1.0 / arr(v(1)))
    val queue = collection.mutable.PriorityQueue.empty[Array[Int]](ordering)
    (0 until arr.length - 1).foreach(i =>
      queue.enqueue(Array(i, arr.length - 1))
    )

    (0 until k).foreach { i =>
      val v = queue.dequeue()
      // println(arr(v(0)), arr(v(1)))
      if (i == k - 1) return Array(arr(v(0)), arr(v(1)))
      if (v(0) != v(1) - 1) queue.enqueue(Array(v(0), v(1) - 1))
    }

    Array.empty[Int]
  }
}
