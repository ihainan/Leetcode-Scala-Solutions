package me.ihainan

object R1715 {

  class Trie {

    class Node(val c: Char) {
      val children = new Array[Node](26)
      var terminal = false
    }

    val root = new Node(' ')

    def addWord(str: String): Unit = {
      var p = root
      str.foreach { c =>
        if (p.children(c - 'a') == null) p.children(c - 'a') = new Node(c)
        p = p.children(c - 'a')
      }
      p.terminal = true
    }

    def findMatches(str: String, e: Int): List[Int] = {
      var p = root
      var s = e
      val ans = collection.mutable.ListBuffer.empty[Int]
      while (s >= 0 && p != null) {
        val c = str(s)
        val child = p.children(c - 'a')
        if (child != null && child.terminal) ans += s
        s -= 1
        p = child
      }
      ans.toList
    }

    def verify(str: String): Boolean = {
      val dp = new Array[Boolean](str.length + 1)
      dp(0) = true
      (1 to str.length).foreach { i =>
        val matches = findMatches(str, i - 1)
        val newMatches = if (i == str.length) matches.filter(_ != 0) else matches
        dp(i) = newMatches.exists(s => dp(s))
      }
      dp.last
    }
  }

  def longestWord(words: Array[String]): String = {
    val sorted = words.sortWith { case (w1, w2) =>
      if (w1.length == w2.length) w1 < w2
      else w1.length > w2.length
    }
    val trie = new Trie()
    sorted.foreach { word => trie.addWord(word.reverse) }
    sorted.foreach { word => if (trie.verify(word)) return word }
    ""
  }
}