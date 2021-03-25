package me.ihainan

object R1618 {
  def verify(first: String, countFirst: Int, second: String, countSecond: Int, pattern: String, value: String): Boolean = {
    if (first == second) false
    else if (first.length * countFirst + second.length * countSecond != value.length) false
    else {
      val sb = new StringBuilder()
      pattern.map(c => sb.append(if (c == 'a') first else second))
      sb.toString == value
    }
  }

  def patternMatching(pattern: String, value: String): Boolean = {
    if (pattern == "") return value == ""
    if (value == "") return pattern.indexOf('a') == -1 || pattern.indexOf('b') == -1

    val next = pattern.indexOf(if (pattern.head == 'a') 'b' else 'a')
    val countA = pattern.count(_ == 'a')
    val countB = pattern.count(_ == 'b')

    (0 until value.length).foreach { i =>
      val first = value.substring(0, i + 1)
      val seconds = if (next == -1) Array("") else ((i + 1) * next until value.length).map(j => value.substring((i + 1) * next, j + 1)).toArray :+ ""
      seconds.foreach { second =>
        if (verify(first, countA, second, countB, pattern, value)) return true
        if (verify(second, countA, first, countB, pattern, value)) return true
      }
    }

    false
  }
}