package me.ihainan

object P8Solution2 {
  def myAtoi(str: String): Int = {
    var metNum = false
    var metSign = false
    var mul = 1
    var ans = 0L
    str.foreach {
      case c if c >= '0' && c <= '9' =>
        metNum = true
        val sum = ans * 10 + c - '0'
        if (sum * mul > Int.MaxValue) return Int.MaxValue
        else if (sum * mul < Int.MinValue) return Int.MinValue
        else ans = sum
      case ' ' if !metSign && !metNum => // nothing to do
      case c if (c == '+' || c == '-') && !metSign && !metNum =>
        metSign = true
        if (c == '-') mul = -1
      case c if metSign && !metNum => return 0 // character between sign & num
      case c if metNum => return (mul * ans).toInt
      case c => return 0
    }
    (mul * ans).toInt
  }
}