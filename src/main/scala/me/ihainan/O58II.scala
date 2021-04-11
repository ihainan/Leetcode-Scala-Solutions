package me.ihainan

object O58II {
  def reverseLeftWords(s: String, n: Int): String = {
    s.substring(n, s.length) + s.substring(0, n)
  }
}