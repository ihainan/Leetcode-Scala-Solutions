package me.ihainan

object P139Solution2 {
  class Trie(words: List[String]) {
    class Node(val c: Char) {
      val children = new Array[Node](26)
      var isTerminate: Boolean = false
    }

    var root = new Node(' ')
    words.foreach(word => addWord(word))

    def addWord(word: String): Unit = {
      var p = root
      word.foreach { c =>
        if (p.children(c - 'a') == null) p.children(c - 'a') = new Node(c)
        p = p.children(c - 'a')
      }
      p.isTerminate = true
    }

    def findMatches(s: String, start: Int): List[Int] = {
      val ans = collection.mutable.ListBuffer.empty[Int]
      var p = root
      (start until s.length).foreach { i =>
        if (p.children(s(i) - 'a') == null) return ans.toList
        p = p.children(s(i) - 'a')
        if (p.isTerminate) ans += i
      }
      ans.toList
    }
  }

  def wordBreak(s: String, wordDict: List[String]): Boolean = {
    val trie = new Trie(wordDict)
    val dp = new Array[Boolean](s.length)
    s.indices.foreach { i =>
      if (i == 0 || dp(i - 1)) {
        trie.findMatches(s, i).foreach { e => dp(e) = true }
      }
    }
    dp.last
  }
}
