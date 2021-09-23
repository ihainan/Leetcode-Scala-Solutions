package me.ihainan

object O59II {

  class MaxQueue() {
    val q1 = new java.util.LinkedList[Int]()
    val q2 = new java.util.LinkedList[Int]()

    def max_value(): Int = {
      if (q1.size == 0) -1
      else q2.getFirst
    }

    def push_back(value: Int) {
      q1.addLast(value)
      while (q2.size > 0 && q2.getLast < value) q2.removeLast
      q2.addLast(value)
    }

    def pop_front(): Int = {
      if (q1.size == 0) -1
      else {
        val value = q1.removeFirst
        if (q2.getFirst == value) q2.removeFirst
        value
      }
    }

  }

  /**
    * Your MaxQueue object will be instantiated and called as such:
    * var obj = new MaxQueue()
    * var param_1 = obj.max_value()
    * obj.push_back(value)
    * var param_3 = obj.pop_front()
    */
}