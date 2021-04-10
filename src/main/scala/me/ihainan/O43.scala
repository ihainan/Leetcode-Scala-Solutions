package me.ihainan

object O43 {
  def countDigitOne(n: Int): Int = {
    val str = n.toString
    var ans = 0
    str.indices.foreach { i =>
      val iNum = str(i) - '0'
      val left = if (i == 0) 0 else Integer.parseInt(str.substring(0, i))
      val right = if (i == str.length - 1) 0 else Integer.parseInt(str.substring(i + 1, str.length))
      val powValue = if (i == str.length - 1) 1 else math.pow(10, str.substring(i + 1, str.length).length).toInt

      if (iNum == 0) ans += left * powValue
      else if (iNum > 1) ans += (left + 1) * powValue
      else ans += left * powValue + 1 + right
    }
    ans
  }
}