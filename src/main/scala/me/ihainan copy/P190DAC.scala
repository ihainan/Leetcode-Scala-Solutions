package me.ihainan

object P190DAC {
  // you need treat n as an unsigned value
  val M1 = 0x55555555 // 01010101 01010101 01010101 01010101
  val M2 = 0x33333333 // 00110011 00110011 00110011 00110011
  val M3 = 0x0F0F0F0F // 00001111 00001111 00001111 00001111
  val M4 = 0x00FF00FF // 00000000 11111111 00000000 11111111
  val M5 = 0x0000FFFF // 00000000 00000000 11111111 11111111
  def reverseBits(x: Int): Int = {
    var n = x
    n = ((n >> 1) & M1) | ((M1 & n) << 1)
    n = ((n >> 2) & M2) | ((M2 & n) << 2)
    n = ((n >> 4) & M3) | ((M3 & n) << 4)
    n = ((n >> 8) & M4) | ((M4 & n) << 8)
    n = ((n >> 16) & M5) | ((M5 & n) << 16)
    n
  }
}