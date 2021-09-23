package me.ihainan

object P151 {
  def reverseWords(s: String): String = {
    s.trim.split(" ").filter(_.length > 0).reverse.mkString(" ")
  }
}