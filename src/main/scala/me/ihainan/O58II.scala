package me.ihainan

object O58II {
  def reverseLeftWords(s: String, n: Int): String = {
    val chars = new Array[Char](s.length)
    (0 until s.length).foreach { i => chars(i) = s((n + i) % s.length) }
    new String(chars)
  }
}