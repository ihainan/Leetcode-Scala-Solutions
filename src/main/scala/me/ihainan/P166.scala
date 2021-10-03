package me.ihainan

object P166 {
  def fractionToDecimal(numerator: Int, denominator: Int): String = {
    val map = collection.mutable.Map.empty[Long, Int]
    val sign = if (numerator * 1.0 / denominator < 0) "-" else ""
    var (a, b) = (numerator.toLong.abs, denominator.toLong.abs)
    val sb = new StringBuilder()
    sb.append(sign + (a / b).toString + (if (a % b == 0) "" else "."))

    while (a % b != 0 && !map.isDefinedAt((a % b) * 10)) {
      a = (a % b) * 10
      map(a) = sb.length
      sb.append(a / b)
    }

    if (a % b == 0) return sb.toString
    val index = ((a % b) * 10).toInt
    sb.substring(0, map(index)) + "(" + sb.substring(
      map(index),
      sb.length
    ) + ")"
  }
}
