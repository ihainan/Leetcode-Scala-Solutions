package me.ihainan

object P389 {
  class Solution(_nums: Array[Int]) {
    val nums = _nums.clone
    var current = _nums.clone
    val random = new util.Random()

    def reset(): Array[Int] = {
      nums
    }

    def shuffle(): Array[Int] = {
      val set = collection.mutable.Set.empty[Int]
      while (set.size != nums.length) {
        val next = random.nextInt(nums.length)
        if (!set(next)) {
          current(set.size) = nums(next)
          set += next
        }
      }
      current
    }

  }

  /** Your Solution object will be instantiated and called as such: var obj =
    * new Solution(nums) var param_1 = obj.reset() var param_2 = obj.shuffle()
    */
}
