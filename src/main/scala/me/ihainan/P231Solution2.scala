package me.ihainan

object P231Solution2 {
  def isPowerOfTwo(n: Int): Boolean = {
    if (n <= 0) return false
    var count = 0
    (0 until 31).foreach { i =>
      val mask = 1 << i
      if ((mask & n) != 0) count += 1
      if (count > 1) return false
    }
    true
  }
}
