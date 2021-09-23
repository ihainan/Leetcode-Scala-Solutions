package me.ihainan

class R0305() {
  var min = Int.MinValue
  val stack = collection.mutable.Stack.empty[Int]

  def push(x: Int): Unit = {
    val tmp = collection.mutable.Stack.empty[Int]
    while (stack.nonEmpty && stack.top < x) tmp.push(stack.pop)
    stack.push(x)
    while (tmp.nonEmpty) stack.push(tmp.pop)
  }

  def pop(): Unit = if (!isEmpty) stack.pop

  def peek(): Int = if (isEmpty) -1 else stack.top

  def isEmpty(): Boolean = stack.isEmpty
}

/**
 * Your SortedStack object will be instantiated and called as such:
 * var obj = new SortedStack()
 * obj.push(`val`)
 * obj.pop()
 * var param_3 = obj.peek()
 * var param_4 = obj.isEmpty()
 */
