package me.ihainan

object R0507 {
  def exchangeBits(num: Int): Int = {
    ((num & 0xaaaaaaaa) >> 1) | ((num & 0x55555555) << 1)
  }
}