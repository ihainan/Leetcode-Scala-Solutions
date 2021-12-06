package me.ihainan

object P20 {
  def isValid(s: String): Boolean = {
    val stack = collection.mutable.Stack.empty[Char]
    s.foreach { c =>
      if (c == '(' || c == '{' || c == '[') stack.push(c)
      else if (stack.isEmpty) return false
      else if (c == ')' && stack.top != '(') return false
      else if (c == '}' && stack.top != '{') return false
      else if (c == ']' && stack.top != '[') return false
      else stack.pop
    }
    stack.isEmpty
  }
}
