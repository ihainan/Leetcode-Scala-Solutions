package me.ihainan

object P187 {
  val map = "ACGT".zipWithIndex.toMap
  val pow = 1 << 18

  def findRepeatedDnaSequences(s: String): List[String] = {
    if (s.length <= 10) return Nil
    val ans = collection.mutable.ListBuffer.empty[String]
    val seen = collection.mutable.Map.empty[Int, Int].withDefaultValue(0)
    var h = 0
    (0 until 10).foreach { i => h = h * 4 + map(s(i)) }
    seen(h) = 1
    (1 to s.length - 10).foreach { i =>
      h = h - pow * map(s(i - 1))
      h = h * 4 + map(s(i + 9))
      if (seen(h) == 1) ans += s.substring(i, i + 10)
      seen(h) = seen(h) + 1
    }
    ans.toList
  }
}
