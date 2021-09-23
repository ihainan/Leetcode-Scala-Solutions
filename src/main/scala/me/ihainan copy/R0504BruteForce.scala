package me.ihainan

object R0504BruteForce {
  def numOf1s(num: Int): Int = {
    (0 until 32).count(i => getI(num, i) == 1)
  }

  def getI(num: Int, i: Int): Int = {
    val mask = 1 << i
    if ((mask & num) == mask) 1 else 0
  }

  def findClosedNumbers(num: Int): Array[Int] = {
    val ones = numOf1s(num)
    val minNumWithOnes = Integer.parseInt("1" * ones, 2)
    val maxNumWithOnes = Integer.parseInt("1" * ones + "0" * (31 - ones), 2)
    var (max, min) = (-1, -1)

    var num2 = num + 1
    while (max == -1 && num2 <= maxNumWithOnes && num2 > 0) {
      if (numOf1s(num2) == ones) max = num2
      num2 += 1
    }

    num2 = num - 1
    while (min == -1 && num2 >= minNumWithOnes) {
      if (numOf1s(num2) == ones) min = num2
      num2 -= 1
    }

    Array(max, min)
  }
}