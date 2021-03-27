package me.ihainan

import scala.collection.mutable.Map

object R1713DP {

  class Trie {

    class Node(c: Char) {
      val children = new Array[Node](26)
      var terminal = false
    }

    val root = new Node(' ')

    def addWord(word: String): Unit = {
      var p = root
      word.foreach { c =>
        if (p.children(c - 'a') == null) p.children(c - 'a') = new Node(c)
        p = p.children(c - 'a')
      }
      p.terminal = true
    }

    def findMatches(str: String, e: Int): List[Int] = {
      var p = root
      var i = e
      val ends = collection.mutable.ListBuffer.empty[Int]
      while (i >= 0 && p != null) {
        val child = p.children(str(i) - 'a')
        if (child != null && child.terminal) ends += i
        i -= 1
        p = child
      }
      ends.toList
    }
  }

  def respace(dictionary: Array[String], sentence: String): Int = {
    val trie = new Trie()
    dictionary.foreach(word => trie.addWord(word.reverse))
    val dp = new Array[Int](sentence.length + 1)
    (1 until dp.length).foreach { i =>
      dp(i) = dp(i - 1) + 1 // skip current character
      val starts = trie.findMatches(sentence, i - 1)
      starts.foreach { s => dp(i) = dp(i).min(dp(s)) }
    }
    dp.last
  }
}