package me.ihainan

object P384Solution3 {
  class Solution(_nums: Array[Int]) {
    val origin = _nums.clone
    val r = new util.Random()

    def reset(): Array[Int] = {
      origin
    }

    def shuffle(): Array[Int] = {
      val nums = new Array[Int](origin.length)
      val list = origin.clone

      nums.indices.foreach { i =>
        val j = r.nextInt(nums.length - i)
        nums(i) = list(j)
        val tmp = list(nums.length - i - 1)
        list(nums.length - i - 1) = list(j)
        list(j) = tmp
      }

      nums
    }

  }

  /** Your Solution object will be instantiated and called as such: var obj =
    * new Solution(nums) var param_1 = obj.reset() var param_2 = obj.shuffle()
    */
}
