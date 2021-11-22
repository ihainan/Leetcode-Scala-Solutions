package me.ihainan

object P384Solution2 {
  class Solution(_nums: Array[Int]) {
    val origin = _nums.clone
    val r = new util.Random()

    def reset(): Array[Int] = {
      origin
    }

    def shuffle(): Array[Int] = {
      val nums = new Array[Int](origin.length)
      val list = collection.mutable.ArrayBuffer(origin: _*)

      nums.indices.foreach { i =>
        val j = r.nextInt(list.length)
        nums(i) = list(j)
        list.remove(j)
      }

      nums
    }

  }

  /** Your Solution object will be instantiated and called as such: var obj =
    * new Solution(nums) var param_1 = obj.reset() var param_2 = obj.shuffle()
    */
}
