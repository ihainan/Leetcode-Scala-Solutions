package me.ihainan

object P981 {
  class TimeMap() {
    val map = collection.mutable.Map
      .empty[String, Array[(Int, String)]]
      .withDefaultValue(Array.empty)

    /** Initialize your data structure here. */
    def set(key: String, value: String, timestamp: Int) {
      map(key) = map(key) :+ (timestamp, value)
    }

    def get(key: String, timestamp: Int): String = {
      val arr = map(key)

      @annotation.tailrec
      def find(l: Int, r: Int): String = {
        if (l > r) ""
        else if (arr(r)._1 <= timestamp) arr(r)._2
        else {
          val mid = (l + r) >>> 1
          if (arr(mid)._1 <= timestamp) find(mid, r - 1)
          else find(l, mid - 1)
        }
      }

      find(0, arr.length - 1)
    }

  }

  /** Your TimeMap object will be instantiated and called as such:
    * var obj = new TimeMap()
    * obj.set(key,value,timestamp)
    * var param_2 = obj.get(key,timestamp)
    */
}
