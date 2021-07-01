package me.ihainan

object O64 {
  def sumNums(n: Int): Int = {
    var sum = n
    n > 0 && {
      sum += sumNums(n - 1)
      sum >= 0
    }
    sum
  }
}