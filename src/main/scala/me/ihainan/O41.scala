package me.ihainan

object O41 {

  class MedianFinder() {

    import collection.mutable.ArrayBuffer

    /** initialize your data structure here. */
    val nums = ArrayBuffer.empty[Int]

    def addNum(num: Int) {
      val index = find(nums, 0, nums.length - 1, num)
      if (index == -1) nums += num
      else nums.insert(index, num)
    }

    @annotation.tailrec
    final def find(nums: ArrayBuffer[Int], l: Int, r: Int, target: Int): Int = {
      if (l > r) -1
      else if (nums(l) >= target) l
      else {
        val mid = (l + r) >>> 1
        if (nums(mid) >= target) find(nums, l + 1, mid, target)
        else find(nums, mid + 1, r, target)
      }
    }

    def findMedian(): Double = {
      if ((nums.length & 1) == 1) nums(nums.length / 2)
      else (nums(nums.length / 2) + nums((nums.length - 1) / 2)) * 1.0 / 2
    }
  }

  /**
    * Your MedianFinder object will be instantiated and called as such:
    * var obj = new MedianFinder()
    * obj.addNum(num)
    * var param_2 = obj.findMedian()
    */
}