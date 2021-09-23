package me.ihainan

object P1720 {
  def decode(encoded: Array[Int], first: Int): Array[Int] = {
    var tmp = first
    first +: encoded.map { num => tmp ^= num; tmp }
  }
}