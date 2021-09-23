package me.ihainan

object R0506 {
  def convertInteger(A: Int, B: Int): Int = {
    var num = A ^ B
    var count = 0
    while (num != 0) {
      count += 1;
      num = num & (num - 1)
    }
    count
  }
}