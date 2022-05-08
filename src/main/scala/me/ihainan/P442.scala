package me.ihainan

object P442 {
  def findDuplicates(nums: Array[Int]): List[Int] = {
    nums.foreach { num =>
      nums((num - 1) % nums.length) += nums.length
    }
    nums.indices.filter(i => nums(i) > 2 * nums.length).map(_ + 1).toList
  }
}