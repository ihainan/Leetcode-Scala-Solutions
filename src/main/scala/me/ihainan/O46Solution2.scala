
package me.ihainan

object O46Solution2 {
  def translateNum(num: Int): Int = {
    val str = num.toString
    var (dp0, dp1) = (0, 0)
    str.indices.foreach { i =>
      val single = if (i == 0) 1 else dp1
      val double = if (i == 0) 0 else {
        val n = str.substring(i - 1, i + 1).toInt
        if (n < 10 || n > 25) 0 else if (i == 1) 1 else dp0
      }
      dp0 = dp1
      dp1 = single + double
    }
    dp1
  }
}