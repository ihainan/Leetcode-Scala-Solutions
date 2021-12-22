package me.ihainan

object P686 {
  def repeatedStringMatch(a: String, b: String): Int = {
    val (l1, l2) = (a.length, b.length)
    val n = math.ceil(l2 * 1.0 / l1).toInt
    var aa = a * n
    if (aa.contains(b)) n
    else if ((aa + a).contains(b)) n + 1
    else -1
  }
}
