package me.ihainan

object P257 {
  def generatePalindromes(s: String): List[String] = {
    val map = collection.mutable.Map.empty[Char, Int].withDefaultValue(0)
    s.foreach { c => map(c) = map(c) + 1 }

    val odd = map.filter(_._2 % 2 == 1)
    if (odd.size > 1) return Nil

    val even = map.filter(_._2 % 2 == 0)
    odd.foreach { case (k, v) => if (v > 1) { even(k) = v - 1; odd(k) = 1 } }
    val oddStr = if (odd.isEmpty) "" else odd.keySet.mkString
    val choices = even.toArray.flatMap { case (k, v) => Array.fill(v / 2)(k) }
    val ans = collection.mutable.ListBuffer.empty[String]
    val visited = collection.mutable.Set.empty[Int]
    val chars = new Array[Char](choices.length)

    def visit(depth: Int): Unit = {
      if (depth == choices.length) ans += new String(chars) + oddStr + new String(chars.reverse)
      else {
        val set = collection.mutable.Set.empty[Char]
        choices.indices.foreach { i =>
          if (!visited(i) && !set(choices(i))) {
            set += choices(i)
            visited += i
            chars(depth) = choices(i)
            visit(depth + 1)
            visited -= i
          }
        }
      }
    }

    visit(0)
    ans.toList
  }
}