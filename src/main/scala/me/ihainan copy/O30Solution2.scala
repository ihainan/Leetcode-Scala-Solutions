package me.ihainan

object O30Solution2 {
  val s1 = collection.mutable.Stack.empty[Long]
  var m = 0L

  /** initialize your data structure here. */
  def push(x: Int) {
    if (s1.isEmpty) {
      s1.push(0)
      m = x
    } else {
      s1.push(x.toLong - m)
      m = m.min(x)
    }
  }

  def pop() {
    val v = s1.pop
    if (v < 0) m = m - v
  }

  def top(): Int = {
    val v = s1.top
    if (v < 0) m.toInt
    else (m + v).toInt
  }

  def min(): Int = {
    m.toInt
  }

}

/**
  * Your MinStack object will be instantiated and called as such:
  * var obj = new MinStack()
  * obj.push(x)
  * obj.pop()
  * var param_3 = obj.top()
  * var param_4 = obj.min()
  */