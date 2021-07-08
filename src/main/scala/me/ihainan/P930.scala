package me.ihainan

object P281 {
  class ZigzagIterator(_v1: Array[Int], _v2: Array[Int]) {
    /** initialize your data structure here. */
    val indices = Array(0, 0)
    val data = Array(_v1, _v2)
    var current = 0

    def next(): Int = {
      while (indices(current) == data(current).length) current = (current + 1) % 2
      val value = data(current)(indices(current))
      indices(current) += 1
      current = (current + 1) % 2
      value
    }

    def hasNext(): Boolean = {
      data.indices.exists(i => indices(i) != data(i).length)
    }
  }

  /**
    * Your ZigzagIterator object will be instantiated and called as such:
    * var obj = new ZigzagIterator(v1, v2)
    * while (obj.hasNext()) {
    *     ans += obj.next()
    * }
    */
}