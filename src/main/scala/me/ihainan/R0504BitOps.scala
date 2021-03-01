package me.ihainan

object R0504BitOps {
  def getI(num: Int, i: Int): Int = {
    val mask = 1 << i
    if ((mask & num) == mask) 1 else 0
  }

  def findClosedNumbers(num: Int): Array[Int] = {
    val maxI = (1 until 31).collectFirst { case i if getI(num, i) == 0 && getI(num, i - 1) == 1 => i }.getOrElse(-1)
    val minI = (1 until 31).collectFirst { case i if getI(num, i) == 1 && getI(num, i - 1) == 0 => i }.getOrElse(-1)
    val max = if (maxI == -1) -1 else {
      val ones = (0 until maxI).count(i => getI(num, i) == 1)
      val ans = (num | (1 << maxI)) & ~((1 << maxI) - 1) // Set maxI to 1 and clear the first (maxI - 1) bits
      ans | ((1 << (ones - 1)) - 1)
    }

    val min = if (minI == -1) -1 else {
      val ones = (0 until minI).count(i => getI(num, i) == 1)
      val ans = (~(1 << minI) & num) & ~((1 << minI) - 1) // Set minI to 0 and clear the first (minI - 1) bits
      ans | (((1 << (ones + 1)) - 1) << (minI - ones - 1))
    }

    Array(max, min)
  }
}