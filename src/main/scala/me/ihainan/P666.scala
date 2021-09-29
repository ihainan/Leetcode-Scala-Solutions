package me.ihainan

object P666 {
  def pathSum(nums: Array[Int]): Int = {
    val map = collection.mutable.Map.empty[(Int, Int), Int]
    nums.foreach { num => map((num / 100, (num % 100) / 10)) = num % 10 }

    def solve(d: Int, p: Int, sum: Int): Int = {
      if (!map.isDefinedAt((d, p))) 0
      else {
        val (left, right) = (2 * p - 1, 2 * p)
        val newSum = sum + map((d, p))
        if (!map.isDefinedAt((d + 1, left)) && !map.isDefinedAt((d + 1, right))) newSum
        else solve(d + 1, left, newSum) + solve(d + 1, right, newSum)
      }
    }

    solve(1, 1, 0)
  }
}
