package me.ihainan

object P387 {
  def firstUniqChar(s: String): Int = {
    val map = collection.mutable.Map.empty[Char, Int].withDefaultValue(0)
    s.foreach(c => map(c) += 1)
    s.indices.collectFirst { case i if map(s(i)) == 1 => i }.getOrElse(-1)
  }
}
