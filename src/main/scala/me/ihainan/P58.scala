package me.ihainan

object P58 {
  def lengthOfLastWord(s: String): Int = {
    var i = s.length - 1
    while (i >= 0 && s(i) == ' ') i -= 1
    val end = i
    while (i >= 0 && s(i) != ' ') i -= 1
    end - i
  }
}