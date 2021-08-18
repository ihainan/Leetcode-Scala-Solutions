package me.ihainan

object P1256 {
  def encode(num: Int): String = {
    (num + 1).toBinaryString.substring(1)
  }
}
