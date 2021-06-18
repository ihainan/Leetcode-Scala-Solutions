package me.ihainan

object P65 {
  def validNumber(s: String, shouldBeInteger: Boolean): Boolean = {
    if (s.isEmpty) false
    else {
      var dotExists = false
      var hasNumber = false
      val start = if (s.startsWith("+") || s.startsWith("-")) 1 else 0
      (start until s.length).foreach { i =>
        s(i) match {
          case '.' if dotExists || shouldBeInteger => return false
          case '.' => dotExists = true
          case c if c < '0' || c > '9' => return false
          case c => hasNumber = true
        }
      }
      hasNumber
    }
  }

  def isNumber(s: String): Boolean = {
    val ss = s.trim
    if (ss.contains('e')) {
      val index = ss.indexOf('e')
      validNumber(ss.substring(0, index), false) && validNumber(ss.substring(index + 1, ss.length), true)
    } else if (ss.contains('E')) {
      val index = ss.indexOf('E')
      validNumber(ss.substring(0, index), false) && validNumber(ss.substring(index + 1, ss.length), true)
    } else validNumber(ss, false)
  }
}