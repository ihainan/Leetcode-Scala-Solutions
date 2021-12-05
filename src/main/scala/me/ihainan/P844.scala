package me.ihainan

object P844 {
  def buildStr(s: String): String = {
    val stack = collection.mutable.Stack.empty[Char]
    val sb = new StringBuilder()
    (s.length - 1 to 0 by -1).foreach { i =>
      if (s(i) == '#') stack.push(s(i))
      else {
        if (stack.nonEmpty && stack.top == '#') {
          stack.pop()
        } else {
          sb.append(s(i))
        }
      }
    }
    sb.toString()
  }

  def backspaceCompare(s: String, t: String): Boolean = {
    buildStr(s) == buildStr(t)
  }
}
