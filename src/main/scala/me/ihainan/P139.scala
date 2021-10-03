package me.ihainan

object P139 {
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
    val memo = collection.mutable.Map.empty[Int, Boolean]

    def find(i: Int): Boolean = {
      if (memo.isDefinedAt(i)) memo(i)
      else if (i == s.length) true
      else {
        memo(i) = trie.findMatches(s, i).exists { e => find(e + 1) }
        memo(i)
      }
    }

    find(0)
  }
}
