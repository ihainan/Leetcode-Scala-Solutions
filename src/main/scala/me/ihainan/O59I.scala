package me.ihainan

object O59I {
  def maxSlidingWindow(nums: Array[Int], k: Int): Array[Int] = {
    val queue = new java.util.LinkedList[Int]()
    val ans = collection.mutable.ArrayBuffer.empty[Int]
    nums.indices.foreach { i =>
      val num = nums(i)
      if (i >= k && queue.getLast == nums(i - k)) queue.removeLast()
      while (queue.size() > 0 && queue.getFirst < num) queue.removeFirst()
      queue.addFirst(num)
      if (i >= k - 1) ans += queue.getLast
    }
    ans.toArray
  }
}