package me.ihainan

object P800 {
  def similarRGB(color: String): String = {
    def findNearest(color: String): Char = {
      val num1 = Integer.parseInt(color, 16)
      var min = Int.MaxValue
      var ans = 0
      (0 until 16).foreach { i =>
        val num2 = i * 16 + i
        if ((num2 - num1).abs < min) {
          min = (num2 - num1).abs
          ans = i
        }
      }

      if (ans < 10) ('0' + ans).toChar else ('a' + ans - 10).toChar
    }

    val c1 = findNearest(color.substring(1, 3))
    val c2 = findNearest(color.substring(3, 5))
    val c3 = findNearest(color.substring(5, 7))
    "#" + c1 + c1 + c2 + c2 + c3 + c3
  }
}