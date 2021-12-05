package me.ihainan

object P232 {
  class MyQueue() {
    val s1 = collection.mutable.Stack.empty[Int]
    val s2 = collection.mutable.Stack.empty[Int]

    def push(x: Int): Unit = {
      s1.push(x)
    }

    def pop(): Int = {
      if (s2.nonEmpty) s2.pop
      else {
        while (s1.nonEmpty) s2.push(s1.pop)
        s2.pop
      }
    }

    def peek(): Int = {
      if (s2.isEmpty) {
        while (s1.nonEmpty) s2.push(s1.pop)
      }
      s2.top
    }

    def empty(): Boolean = {
      s1.isEmpty && s2.isEmpty
    }

  }

  /** Your MyQueue object will be instantiated and called as such:
    * var obj = new MyQueue()
    * obj.push(x)
    * var param_2 = obj.pop()
    * var param_3 = obj.peek()
    * var param_4 = obj.empty()
    */
}
