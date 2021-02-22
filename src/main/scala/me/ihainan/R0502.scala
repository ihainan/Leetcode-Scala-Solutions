package me.ihainan

object R0502 {
  def printBin(n: Double): String = {
    var num = n
    var c = 1.0
    val sb = new StringBuilder()
    sb.append("0.")
    while (num > 0) {
      c = c / 2
      if (num >= c * 2) return "ERROR"
      else if (num < c) sb.append(0)
      else {
        sb.append(1)
        num -= c
      }

      if (sb.length > 34) return "ERROR"
    }

    sb.toString
  }
}