package me.ihainan

object P1119 {
  def removeVowels(s: String): String = {
    val set = "aeiou".toSet
    new String(s.filter(c => !set(c)))
  }
}