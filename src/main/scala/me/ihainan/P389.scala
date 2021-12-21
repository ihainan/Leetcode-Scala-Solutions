package me.ihainan

object P389 {
  class Solution(_nums: Array[Int]) {
    val random = new util.Random()
    val indices = _nums.indices.toArray
    val nums = _nums.clone

    def reset(): Array[Int] = {
      nums.clone
    }

    def shuffle(): Array[Int] = {
      (nums.length - 1 to 0 by -1).map { i =>
        val r = random.nextInt(i + 1)
        val tmp = indices(r)
        indices(r) = indices(i)
        indices(i) = tmp
        nums(indices(i))
      }.toArray
    }

  }

  /** Your Solution object will be instantiated and called as such:
    * var obj = new Solution(nums)
    * var param_1 = obj.reset()
    * var param_2 = obj.shuffle()
    */
}
