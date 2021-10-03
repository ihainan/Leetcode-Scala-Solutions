package me.ihainan

object P405 {
  def toHex(num: Int): String = {
    if (num == 0) return "0"
    var lNum = if (num > 0) num else (1.toLong << 32) + num
    val sb = new StringBuilder()
    while (lNum != 0) {
      val r = lNum % 16
      if (r <= 9) sb.append(r) else sb.append(('a' + r - 10).toChar)
      lNum /= 16
    }
    val str = sb.toString
    str.substring(0, str.length.min(8)).reverse
  }
}
