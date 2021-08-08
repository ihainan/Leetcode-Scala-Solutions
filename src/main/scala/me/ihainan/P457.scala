package me.ihainan

object P457 {
  def circularArrayLoop(nums: Array[Int]): Boolean = {
    val len = nums.length

    def pos(v: Int): Int = {
      if (v > 0) v % len else (v % len + len) % len
    }

    nums.indices.foreach { i =>
      var (j, counter) = (i, 0)
      val map = collection.mutable.Map.empty[Int, Int]

      while (nums(i) * nums(pos(j)) > 0 && !map.isDefinedAt(pos(j))) {
        map(pos(j)) = counter
        counter += 1
        j += nums(pos(j))
      }

      if (nums(i) * nums(pos(j)) > 0 && counter - map(pos(j)) > 1) return true
    }

    false
  }
}