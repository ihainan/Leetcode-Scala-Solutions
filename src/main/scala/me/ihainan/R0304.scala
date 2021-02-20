package me.ihainan

class R0304() {

  /** Initialize your data structure here. */
  val s1 = collection.mutable.Stack.empty[Int]
  val s2 = collection.mutable.Stack.empty[Int]

  /** Push element x to the back of queue. */
  def push(x: Int) {
    while (s2.nonEmpty) s1.push(s2.pop)
    s1.push(x)
  }

  /** Removes the element from in front of queue and returns that element. */
  def pop(): Int = {
    while (s1.nonEmpty) s2.push(s1.pop)
    s2.pop
  }

  /** Get the front element. */
  def peek(): Int = {
    while (s1.nonEmpty) s2.push(s1.pop)
    s2.top
  }

  /** Returns whether the queue is empty. */
  def empty(): Boolean = {
    s1.isEmpty && s2.isEmpty
  }

}

/**
 * Your MyQueue object will be instantiated and called as such:
 * var obj = new MyQueue()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.peek()
 * var param_4 = obj.empty()
 */
