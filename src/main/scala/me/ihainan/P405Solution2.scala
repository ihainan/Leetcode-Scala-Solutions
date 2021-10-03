package me.ihainan

object P405Solution2 {
  def toHex(num: Int): String = {
    val sb = new StringBuilder()
    (7 to 0 by -1).foreach { i =>
      val v = (num >> (4 * i)) & 0xf
      if (v > 0 || sb.length > 0) {
        sb.append(if (v < 10) ('0' + v).toChar else ('a' + v - 10).toChar)
      }
    }
    if (sb.length == 0) "0" else sb.toString
  }
}