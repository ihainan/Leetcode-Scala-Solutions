package me.ihainan

import collection.mutable.Stack

object R1626 {
  def isDigit(c: Char) = c >= '0' && c <= '9'

  def calculate(ss: String): Int = {
    val s1 = Stack.empty[Int]
    val s2 = Stack.empty[Char]

    val s = if (ss.trim.head == '-') "0" + ss.trim else ss.trim
    var num = 0
    var negative = false

    s.indices.foreach { i =>
      s(i) match {
        case c if isDigit(c) =>
          num = num * 10 + (c - '0')
          if (i == s.length - 1 || !isDigit(s(i + 1))) {
            if (negative) {
              num = -num
              negative = false
            }
            if (s2.nonEmpty && s2.top == '*') {
              s2.pop;
              s1.push(s1.pop * num)
            }
            else if (s2.nonEmpty && s2.top == '/') {
              s2.pop;
              s1.push(s1.pop / num)
            }
            else s1.push(num)
            num = 0
          }
        case c if c == ' ' =>
        case c =>
          if (c == '-') {
            negative = true
            s2.push('+')
          } else s2.push(c)
      }
    }

    // println(s1.mkString(", "))
    // println(s2.mkString(", "))

    while (s2.nonEmpty) {
      s2.pop
      s1.push(s1.pop + s1.pop)
    }

    s1.top
  }
}