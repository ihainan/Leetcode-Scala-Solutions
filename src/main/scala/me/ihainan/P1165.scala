package me.ihainan

object P1165 {
  def calculateTime(keyboard: String, word: String): Int = {
    val map = keyboard.zipWithIndex.toMap
    var prev = keyboard(0)
    word.map { c =>
      val diff = (map(c) - map(prev)).abs
      prev = c
      diff
    }.sum
  }
}