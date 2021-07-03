package me.ihainan

object P451 {
  def frequencySort(s: String): String = {
    var maxFrequency = 0
    val map = collection.mutable.Map.empty[Char, Int].withDefaultValue(0)
    s.foreach { c => map(c) = map(c) + 1; maxFrequency = maxFrequency.max(map(c)) }
    val buckets = Array.fill[List[Char]](maxFrequency)(Nil)
    map.foreach { case (c, f) => buckets(f - 1) = buckets(f - 1) :+ c }
    val sb = new StringBuilder()
    (maxFrequency - 1 to 0 by -1).foreach { f =>
      buckets(f).foreach { c => (0 to f).foreach { _ => sb.append(c) } }
    }
    sb.toString
  }
}