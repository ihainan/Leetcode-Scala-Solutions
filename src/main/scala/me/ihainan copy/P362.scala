package me.ihainan

object P362 {
  class HitCounter() {

    /** Initialize your data structure here. */
    val queue = new java.util.LinkedList[Int]()

    /** Record a hit.
      *@param timestamp - The current timestamp (in seconds granularity). */
    def hit(timestamp: Int) {
      while (queue.size > 0 && queue.getLast <= timestamp - 300) queue.removeLast()
      queue.addFirst(timestamp)
    }

    /** Return the number of hits in the past 5 minutes.
      *@param timestamp - The current timestamp (in seconds granularity). */
    def getHits(timestamp: Int): Int = {
      while (queue.size > 0 && queue.getLast <= timestamp - 300) queue.removeLast()
      queue.size
    }

  }

  /**
    * Your HitCounter object will be instantiated and called as such:
    * var obj = new HitCounter()
    * obj.hit(timestamp)
    * var param_2 = obj.getHits(timestamp)
    */
}