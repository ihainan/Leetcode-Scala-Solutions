package me.ihainan

object R1706 {
  def getKthMagicNumber(k: Int): Int = {
    val nums = new Array[Int](k)
    nums(0) = 1
    var (a, b, c) = (0, 0, 0)
    (1 until k).foreach { i =>
      nums(i) = (nums(a) * 3).min(nums(b) * 5).min(nums(c) * 7)
      if (nums(i) == nums(a) * 3) a += 1
      if (nums(i) == nums(b) * 5) b += 1
      if (nums(i) == nums(c) * 7) c += 1
    }
    nums(k - 1)
  }
}