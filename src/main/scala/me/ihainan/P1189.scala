package me.ihainan

object P1189 {
  def maxNumberOfBalloons(text: String): Int = {
    val map = collection.mutable.Map.empty[Char, Int].withDefaultValue(0)
    text.foreach(c => map(c) = map(c) + 1)
    "balon".map { c =>
      if (c == 'o' || c == 'l') map(c) / 2 else map(c)
    }.min
  }
}