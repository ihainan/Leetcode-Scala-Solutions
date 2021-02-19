class MinStack() {

  /** initialize your data structure here. */
  val s1 = collection.mutable.Stack.empty[Int]
  val s2 = collection.mutable.Stack.empty[Int]

  def push(x: Int) {
    if (s2.isEmpty || x <= s2.top) s2.push(x)
    s1.push(x)
  }

  def pop() {
    if (s1.nonEmpty) {
      if (s1.pop == s2.top) s2.pop
    }
  }

  def top(): Int = {
    if (s1.isEmpty) -1
    else s1.top
  }

  def getMin(): Int = {
    if (s2.isEmpty) -1
    else s2.top
  }

}

/**
 * Your MinStack object will be instantiated and called as such:
 * var obj = new MinStack()
 * obj.push(x)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */
