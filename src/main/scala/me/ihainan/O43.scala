package me.ihainan

object O43 {
  def countDigitOne(n: Int): Int = {
    val str = n.toString
    var ans = 0
    (0 until str.length).foreach { i =>
      val num = str(i) - '0'
      val left = if (i == 0) 0 else str.substring(0, i).toInt
      val right = if (i == str.length - 1) 0 else str.substring(i + 1, str.length).toInt
      val pow = math.pow(10, str.length - i - 1).toInt
      if (num == 0) ans += left * pow
      else if (num == 1) ans += left * pow + right + 1
      else ans += (left + 1) * pow
    }
    ans
  }
}