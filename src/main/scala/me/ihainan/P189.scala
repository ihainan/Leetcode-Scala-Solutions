package me.ihainan

object P189 {
  def rotate(nums: Array[Int], k: Int): Unit = {
    val kk = k % nums.length
    val ans = new Array[Int](nums.length)
    (0 until kk).foreach(i => ans(i) = nums(nums.length - kk + i))
    (kk until nums.length).foreach(i => ans(i) = nums(i - kk))
    nums.indices.foreach(i => nums(i) = ans(i))
  }
}
