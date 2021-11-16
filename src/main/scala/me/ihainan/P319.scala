package me.ihainan

object P319 {
  def bulbSwitch(n: Int): Int = {
    var count = 0
    (1 to n).foreach { i =>
      val sqrt = math.sqrt(i)
      if (sqrt == sqrt.toInt) count += 1
    }
    count
  }
}
