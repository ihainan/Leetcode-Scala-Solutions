package me.ihainan

object P359 {
  class Logger() {

    /** Initialize your data structure here. */
    val map = collection.mutable.Map.empty[String, Int]

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
      * If this method returns false, the message will not be printed.
      * The timestamp is in seconds granularity. */
    def shouldPrintMessage(timestamp: Int, message: String): Boolean = {
      if (map.isDefinedAt(message) && timestamp - map(message) < 10) false
      else {
        map(message) = timestamp
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