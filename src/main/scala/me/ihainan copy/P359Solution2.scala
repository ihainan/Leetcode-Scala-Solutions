package me.ihainan

object P359Solution2 {
  class Logger() {

    /** Initialize your data structure here. */
    val queue = new java.util.LinkedList[(Int, String)]()
    val set = collection.mutable.Set.empty[String]

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
      * If this method returns false, the message will not be printed.
      * The timestamp is in seconds granularity. */
    def shouldPrintMessage(timestamp: Int, message: String): Boolean = {
      while (queue.size > 0 && queue.getFirst._1 <= timestamp - 10) {
        set -= queue.getFirst._2
        queue.removeFirst
      }

      if (set(message)) false
      else {
        set += message
        queue.addLast((timestamp, message))
        true
      }
    }

  }

  /**
    * Your Logger object will be instantiated and called as such:
    * var obj = new Logger()
    * var param_1 = obj.shouldPrintMessage(timestamp,message)
    */

}