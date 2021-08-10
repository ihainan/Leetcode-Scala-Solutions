package me.ihainan

object P1337Solution3 {
  @annotation.tailrec
  def find(nums: Array[Int], l: Int, r: Int): Int = {
    if (l > r) -1
    else if (nums(r) == 1) r
    else {
      val m = (l + r) >>> 1
      if (nums(m) == 1) find(nums, m, r - 1) else find(nums, l, m - 1)
    }
  } 

  def kWeakestRows(mat: Array[Array[Int]], k: Int): Array[Int] = {
    val ordering = Ordering[(Int, Int)].on { v: (Int, Int) => (-v._2, -v._1) }
    val queue = collection.mutable.PriorityQueue.empty[(Int, Int)](ordering)
    mat.indices.foreach { i => queue.enqueue((i, find(mat(i), 0, mat(i).length - 1))) }
    (0 until k).map {_ => queue.dequeue._1 }.toArray
  }
}