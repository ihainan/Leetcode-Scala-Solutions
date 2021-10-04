package me.ihainan

object P482 {
  def licenseKeyFormatting(s: String, k: Int): String = {
    val sb = new StringBuilder()
    var count = 0
    (s.length - 1 to 0 by -1).foreach { i =>
      if (s(i) != '-') {
        sb.append(Character.toUpperCase(s(i)))
        count += 1
        if (count == k) {
          count = 0
          sb.append('-')
        }
      }
    }
    val str = sb.toString.reverse
    if (str.nonEmpty && str.head == '-') str.substring(1, str.length) else str
  }
}
