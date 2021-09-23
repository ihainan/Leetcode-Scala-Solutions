package me.ihainan

object O41 {

  class MedianFinder() {

    import scala.collection.mutable.ArrayBuffer

    val nums = ArrayBuffer.empty[Int]

    @annotation.tailrec
    private def findFirst(l: Int, r: Int, target: Int): Int = {
      if (l > r) -1
      else if (nums(l) >= target) l
      else {
        val mid = (l + r) >>> 1
        if (nums(mid) < target) findFirst(mid + 1, r, target)
        else findFirst(l + 1, mid, target)
      }
    }


    /** initialize your data structure here. */
    def addNum(num: Int) {
      val index = findFirst(0, nums.length - 1, num)
      if (index == -1) nums += num
      else nums.insert(index, num)
    }

    def findMedian(): Double = {
      if (nums.length % 2 == 1) nums(nums.length / 2)
      else (nums((nums.length - 1) / 2) + nums(nums.length / 2)) * 1.0 / 2
    }

  }


  /**
    * Your MedianFinder object will be instantiated and called as such:
    * var obj = new MedianFinder()
    * obj.addNum(num)
    * var param_2 = obj.findMedian()
    */
}