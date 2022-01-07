package me.ihainan

object P448 {
  def findDisappearedNumbers(nums: Array[Int]): List[Int] = {
    val n = nums.length
    nums.foreach { num => nums((num - 1) % n) += n }
    nums.indices.filter { i => nums(i) <= n }.map(_ + 1).toList
  }
}
