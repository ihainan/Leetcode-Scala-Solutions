package me.ihainan

object P425Solution3 {

  import collection.mutable

  val map = mutable.Map.empty[String, List[String]].withDefaultValue(Nil)

  def buildMap(words: Array[String]): Unit = {
    words.head.indices.foreach { i =>
      words.foreach { word =>
        val prefix = word.substring(0, i + 1)
        map(prefix) = map(prefix) :+ word
      }
    }
  }

  def startsWith(prefix: String): List[String] = map(prefix)

  def wordSquares(words: Array[String]): List[List[String]] = {
    val ans = mutable.ListBuffer.empty[List[String]]
    map.clear()
    buildMap(words)

    def dfs(depth: Int, path: List[String]): Unit = {
      if (depth == words.head.length) ans += path
      else {
        val prefix = new String(path.map(w => w(depth)).toArray)
        startsWith(prefix).foreach(next => dfs(depth + 1, path :+ next))
      }
    }

    words.foreach(word => dfs(1, List(word)))
    ans.toList
  }
}