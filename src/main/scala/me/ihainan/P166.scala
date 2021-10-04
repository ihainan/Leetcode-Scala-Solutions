package me.ihainan

object P166 {
  def fractionToDecimal(numerator: Int, denominator: Int): String = {
    val map =
      collection.mutable.Map.empty[Long, Int] // Dividend -> Start Position
    val sb = new StringBuilder(
      if (numerator * 1.0 / denominator >= 0) "" else "-"
    )
    var (a, b) = (numerator.toLong.abs, denominator.toLong.abs)
    sb.append((a / b) + (if (a % b == 0) "" else "."))

    while ({
      val d = (a % b) * 10
      d != 0 && !map.isDefinedAt(d)
    }) {
      a = (a % b) * 10
      map(a) = sb.length
      sb.append(a / b)
    }

    val d = (a % b) * 10
    if (d == 0) sb.toString
    else sb.substring(0, map(d)) + "(" + sb.substring(map(d), sb.length) + ")"
  }
}
