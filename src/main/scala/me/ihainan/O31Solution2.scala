package me.ihainan

object O31Solution2 {
  def validateStackSequences(pushed: Array[Int], popped: Array[Int]): Boolean = {
    var i = 0
    val stack = collection.mutable.Stack.empty[Int]
    popped.foreach { pop =>
      while (i < pushed.length && (stack.isEmpty || stack.top != pop)) {
        stack.push(pushed(i))
        i += 1
      }
      if (stack.isEmpty || stack.top != pop) return false
      stack.pop
    }
    true
  }
}