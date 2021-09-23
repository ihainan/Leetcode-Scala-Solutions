package me.ihainan

object P168 {
  def convertToTitle(columnNumber: Int): String = {
    val sb = new StringBuilder()
    var num = columnNumber
    while (num > 0) {
      val r = (num - 1) % 26 + 1
      sb.append(('A' + r - 1).toChar)
      num = (num - r) / 26
    }
    sb.reverse.toString
  }
}