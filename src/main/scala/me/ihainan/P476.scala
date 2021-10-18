package me.ihainan

object P476 {
  def findComplement(num: Int): Int = {
    (0 until 31).map { i =>
      val mask = 1 << i
      if (mask <= num && (num & mask) == 0) 1 << i else 0
    }.sum
  }
}