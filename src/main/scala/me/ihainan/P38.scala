package me.ihainan

object P38 {
  def countAndSay(n: Int): String = {
    var s = "1"
    (2 to n).foreach { _ =>
      val sb = new StringBuilder()
      var i = 0
      while (i < s.length) {
        var count = 1
        while (i < s.length - 1 && s(i) == s(i + 1)) {
          count += 1
          i += 1
        }
        sb.append(count + "" + s(i))
        i += 1
      }
      s = sb.toString
    }
    s
  }
}
