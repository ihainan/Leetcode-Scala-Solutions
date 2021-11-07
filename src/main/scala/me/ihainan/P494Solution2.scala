package me.ihainan

object P494Solution2 {
  def findTargetSumWays(nums: Array[Int], target: Int): Int = {
    val map = collection.mutable.Map.empty[(Int, Int), Int]

    def visit(nums: Array[Int], i: Int, currentSum: Int): Int = {
      if (map.isDefinedAt((i, currentSum))) map((i, currentSum))
      else if (i == nums.length) {
        if (currentSum == target) 1 else 0
      } else {
        val ans = visit(nums, i + 1, currentSum + nums(i)) + visit(nums, i + 1, currentSum - nums(i))
        map((i, currentSum)) = ans
        ans
      }
    }

    visit(nums, 0, 0)
  }
}