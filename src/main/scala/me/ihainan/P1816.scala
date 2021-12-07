package me.ihainan

object P1816 {
  def truncateSentence(s: String, k: Int): String = {
    var count = 0
    s.indices.foreach { i =>
      if (s(i) == ' ') count += 1
      if (count == k) return s.substring(0, i)
    }
    s
  }
}
