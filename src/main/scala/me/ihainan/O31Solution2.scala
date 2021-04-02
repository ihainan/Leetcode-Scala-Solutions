package me.ihainan

object O31Solution2 {
  def validateStackSequences(pushed: Array[Int], popped: Array[Int]): Boolean = {
    var i = 0
    val stack = collection.mutable.Stack.empty[Int]
    pushed.foreach { num =>
      stack.push(num)
      while (stack.nonEmpty && stack.top == popped(i)) {
        stack.pop
        i += 1
      }
    }
    stack.isEmpty
  }
}