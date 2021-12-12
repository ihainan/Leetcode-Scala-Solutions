package me.ihainan

object P709 {
  def toLowerCase(s: String): String = {
    s.map { c =>
      if (c >= 'A' && c <= 'Z') (c - 'A' + 'a').toChar
      else c
    }
  }
}
