package me.ihainan

object R0504 {
  def setI(num: Int, i: Int, v: Int): Int = {
    if (v == 1) (1 << i) | num
    else ~(1 << i) & num
  }

  def getI(num: Int, i: Int): Int = {
    val mask = 1 << i
    if ((mask & num) == mask) 1 else 0
  }

  def findClosedNumbers(num: Int): Array[Int] = {
    val maxI = (1 until 31).collectFirst { case i if getI(num, i) == 0 && getI(num, i - 1) == 1 => i }.getOrElse(-1)
    val minI = (1 until 31).collectFirst { case i if getI(num, i) == 1 && getI(num, i - 1) == 0 => i }.getOrElse(-1)
    val max = if (maxI == -1) -1 else {
      val ones = (0 until maxI).count { i => getI(num, i) == 1 }
      (setI(num, maxI, 1) & (-1 << maxI)) | (if (ones <= 1) 0 else Integer.parseInt("1" * (ones - 1), 2))
    }

    val min = if (minI == -1) -1 else {
      val zeros = (0 until minI).count { i => getI(num, i) == 0 }
      (setI(num, minI, 0) & (-1 << minI)) | (if (zeros <= 1) Integer.parseInt("1" * minI, 2) else Integer.parseInt("1" * (minI - zeros + 1) + "0" * (zeros - 1), 2))
    }

    Array(max, min)
  }
}