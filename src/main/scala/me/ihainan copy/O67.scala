package me.ihainan

object O67 {
  def strToInt(s: String): Int = {
    var i = 0
    while (i < s.length && s(i) == ' ') i += 1
    if (i == s.length || (s(i) != '+' && s(i) != '-' && (s(i) < '0' || s(i) > '9'))) 0
    else {
      var positive = 1
      if (s(i) == '-' || s(i) == '+') {
        if (s(i) == '-') positive = -1
        i += 1
      }
      var num = 0L
      while (i < s.length && s(i) >= '0' && s(i) <= '9') {
        num = num * 10 + (s(i) - '0')
        if ((positive * num) > Int.MaxValue) return Int.MaxValue
        else if ((positive * num) < Int.MinValue) return Int.MinValue
        i += 1
      }
      (num * positive).toInt
    }
  }
}