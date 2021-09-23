package me.ihainan

object R1624 {
  def pairSums(nums: Array[Int], target: Int): List[List[Int]] = {
    val map = collection.mutable.Map.empty[Int, Int].withDefaultValue(0)
    val ans = collection.mutable.ListBuffer.empty[List[Int]]
    nums.foreach { num =>
      if (map(target - num) > 0) {
        map(target - num) = map(target - num) - 1
        ans += List(target - num, num)
      } else {
        map(num) = map(num) + 1
      }
    }
    ans.toList
  }
}