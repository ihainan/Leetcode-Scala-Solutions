package me.ihainan

object O41Solution2 {

  class MedianFinder() {
    import collection.mutable.PriorityQueue

    val left = PriorityQueue.empty[Int]
    val right = PriorityQueue.empty[Int](Ordering.Int.reverse)


    /** initialize your data structure here. */
    def addNum(num: Int) {
      // 总是是偶数的时候，n / 2 + n / 2
      // 总数是奇数的时候 (n + 1) / 2, (n - 1) / 2
      if (left.size != right.size) {
        left.enqueue(num)
        right.enqueue(left.dequeue)
      } else {
        right.enqueue(num)
        left.enqueue(right.dequeue)
      }
    }

    def findMedian(): Double = {
      if (left.size == right.size) (left.head + right.head) * 1.0 / 2
      else left.head
    }

  }


  /**
    * Your MedianFinder object will be instantiated and called as such:
    * var obj = new MedianFinder()
    * obj.addNum(num)
    * var param_2 = obj.findMedian()
    */
}