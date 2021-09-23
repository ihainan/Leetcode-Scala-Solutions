package me.ihainan

object O20 {
  def validNumber(s: String, isInteger: Boolean): Boolean = {
    if (s.isEmpty) false
    else {
      val start = if (s(0) == '+' || s(0) == '-') 1 else 0
      var dotExists = false
      var hasNum = false
      (start until s.length).foreach { i =>
        s(i) match {
          case '.' if dotExists || isInteger => return false
          case '.' => dotExists = true
          case c if c < '0' || c > '9' => return false
          case _ => hasNum = true
        }
      }
      hasNum
    }
  }

  def isNumber(ss: String): Boolean = {
    val s = ss.trim
    if (s.contains("e")) {
      val indexE = s.indexOf("e")
      validNumber(s.substring(0, indexE), false) && validNumber(s.substring(indexE + 1, s.length), true)
    } else if (s.contains("E")) {
      val indexE = s.indexOf("E")
      validNumber(s.substring(0, indexE), false) && validNumber(s.substring(indexE + 1, s.length), true)
    } else validNumber(s, false)

  }
}