package me.ihainan

object O67Solution3 {
  def strToInt(str: String): Int = {
    val ss = str.trim
    if (ss.isEmpty || (!Character.isDigit(ss(0)) && ss(0) != '+' && ss(0) != '-')) 0
    else {
      val mul = if (ss(0) == '-') -1 else 1
      var i = if (Character.isDigit(ss(0))) 0 else 1
      var ans = 0L
      while (i < ss.length && Character.isDigit(ss(i))) {
        val sum = ans * 10 + ss(i) - '0'
        if (sum * mul > Int.MaxValue) return Int.MaxValue
        else if (sum * mul < Int.MinValue) return Int.MinValue
        ans = sum
        i += 1
      }
      (ans * mul).toInt
    }
  }
}