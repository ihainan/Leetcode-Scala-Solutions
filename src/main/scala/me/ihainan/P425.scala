package me.ihainan

object P425 {
  def wordSquares(words: Array[String]): List[List[String]] = {
    val ans = collection.mutable.ListBuffer.empty[List[String]]
    val len = words.head.length

    def startsWith(s: String): List[String] = words.filter(_.startsWith(s)).toList

    def dfs(depth: Int, path: List[String]): Unit = {
      if (depth == len) ans += path
      else {
        val prefix = new String((0 until depth).map(i => path(i)(depth)).toArray)
        startsWith(prefix).foreach { next => dfs(depth + 1, path :+ next) }
      }
    }

    words.foreach { w => dfs(1, List(w)) }

    ans.toList
  }
}