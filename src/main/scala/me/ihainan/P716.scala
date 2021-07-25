package me.ihainan

object P716 {
  class MaxStack() {

    /** initialize your data structure here. */
    val s1 = collection.mutable.Stack.empty[Int]
    val s2 = collection.mutable.Stack.empty[Int]

    def push(x: Int) {
      s1.push(x)
      if (s2.isEmpty || s2.top <= x) s2.push(x)
    }

    def pop(): Int = {
      val num = s1.pop()
      if (num == s2.top) s2.pop
      num
    }

    def top(): Int = {
      s1.top
    }

    def peekMax(): Int = {
      s2.top
    }

    def popMax(): Int = {
      val s3 = collection.mutable.Stack.empty[Int]
      while (s1.nonEmpty && s1.top != s2.top) s3.push(s1.pop)
      s1.pop
      val ans = s2.pop
      while (s3.nonEmpty) push(s3.pop)
      ans
    }

  }

  /**
    * Your MaxStack object will be instantiated and called as such:
    * var obj = new MaxStack()
    * obj.push(x)
    * var param_2 = obj.pop()
    * var param_3 = obj.top()
    * var param_4 = obj.peekMax()
    * var param_5 = obj.popMax()
    */
}