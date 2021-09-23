package me.ihainan

object O19 {
  def isMatch(s: String, p: String): Boolean = {
    val (l1, l2) = (s.length, p.length)
    val dp = Array.fill(l1 + 1, l2 + 1)(false)
    (0 to l1).foreach { i =>
      (0 to l2).foreach { j =>
        if (i == 0 && j == 0) dp(i)(j) = true
        else if (j == 0) dp(i)(j) == false
        else {
          p(j - 1) match {
            case '.' => dp(i)(j) = i != 0 && dp(i - 1)(j - 1)
            case '*' =>
              val f1 = j >= 2 && dp(i)(j - 2)
              val f2 = j >= 2 && i != 0 && dp(i - 1)(j) && (s(i - 1) == p(j - 2) || p(j - 2) == '.')
              dp(i)(j) = f1 || f2
            case _ => dp(i)(j) = i != 0 && s(i - 1) == p(j - 1) && dp(i - 1)(j - 1)
          }
        }
      }
    }
    dp(l1)(l2)
  }

  def main(args: Array[String]): Unit = {
    println(isMatch("aab", "c*a*b"))
  }
}