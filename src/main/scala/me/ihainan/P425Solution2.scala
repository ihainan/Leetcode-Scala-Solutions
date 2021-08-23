package me.ihainan

object P425Solution2 {

  import collection.mutable

  class Trie(words: Array[String]) {
    class Node(val c: Char) {
      val children = mutable.Map.empty[Char, Node].withDefaultValue(null)
      var terminate = false
    }

    val root = new Node(' ')
    words.foreach(addWord _)

    def addWord(word: String): Unit = {
      var p = root
      word.foreach { c =>
        if (p.children(c) == null) p.children(c) = new Node(c)
        p = p.children(c)
      }
      p.terminate = true
    }

    def startsWith(str: String): List[String] = {
      val ans = mutable.ListBuffer.empty[String]

      def dfs(depth: Int, p: Node, path: String): Unit = {
        if (depth < str.length) {
          if (p.children(str(depth)) != null) dfs(depth + 1, p.children(str(depth)), path + str(depth))
        } else {
          if (p.terminate) ans += path
          p.children.foreach { case (k, v) => dfs(depth + 1, v, path + k) }
        }
      }

      dfs(0, root, "")
      ans.toList
    }
  }


  def wordSquares(words: Array[String]): List[List[String]] = {
    val ans = collection.mutable.ListBuffer.empty[List[String]]
    val len = words.head.length
    val trie = new Trie(words)

    def dfs(depth: Int, path: List[String]): Unit = {
      if (depth == len) ans += path
      else {
        val prefix = new String((0 until depth).map(i => path(i)(depth)).toArray)
        trie.startsWith(prefix).foreach { next => dfs(depth + 1, path :+ next) }
      }
    }

    words.foreach { w => dfs(1, List(w)) }
    ans.toList
  }
}