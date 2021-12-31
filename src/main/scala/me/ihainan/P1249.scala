package me.ihainan

object P1249 {

  def minRemoveToMakeValid(s: String): String = {
    val set = collection.mutable.Set.empty[Int]
    val stack = collection.mutable.Stack.empty[Int]
    s.indices.foreach { i =>
      if (s(i) == '(') {
        stack.push(i)
      } else if (s(i) == ')') {
        if (stack.nonEmpty && s(stack.top) == '(') {
          set += stack.pop
          set += i
        }
      }
    }

    s.indices
      .filter { i =>
        set(i) || (s(i) != '(' && s(i) != ')')
      }
      .map(i => s(i))
      .mkString
  }
}
