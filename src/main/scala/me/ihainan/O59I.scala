package me.ihainan

object O59I {
  def maxSlidingWindow(nums: Array[Int], k: Int): Array[Int] = {
    val queue = new java.util.LinkedList[Int]()
    nums.indices.flatMap { i =>
      val num = nums(i)
      while (queue.size > 0 && queue.getLast < i - k + 1) queue.removeLast
      while (queue.size > 0 && nums(queue.getFirst) <= num) queue.removeFirst
      queue.addFirst(i)
      if (i >= k - 1) Some(nums(queue.getLast)) else None
    }.toArray
  }
}