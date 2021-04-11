package me.ihainan

object O30 {

  import collection.mutable.Stack

  /** initialize your data structure here. */
  val s1 = Stack.empty[Int]
  val s2 = Stack.empty[Int]

  def push(x: Int) {
    s1.push(x)
    if (s2.isEmpty || x <= s2.top) s2.push(x)
  }

  def pop() {
    val x = s1.pop
    if (s2.nonEmpty && s2.top == x) s2.pop
  }

  def top(): Int = {
    s1.top
  }

  def min(): Int = {
    s2.top
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