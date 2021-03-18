package me.ihainan

object R1605 {
  def numOf5s(num: Int): Int = {
    var num2 = num
    var count = 0
    while ((num2 % 5) == 0) {
      count += 1
      num2 /= 5
    }
    count
  }

  def trailingZeroes(n: Int): Int = {
    var ans = 0
    (1 to n).foreach { num =>
      ans += numOf5s(num)
    }
    ans
  }
}