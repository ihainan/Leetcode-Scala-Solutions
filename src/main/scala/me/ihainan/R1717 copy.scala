package me.ihainan

object P1858 {

  class Trie {
    class Node(val char: Char) {
      val children =
        collection.mutable.Map.empty[Char, Node].withDefaultValue(null)
      var terminate = false
    }

    val root = new Node(' ')

    def addWord(word: String): Unit = {
      var p = root
      word.foreach { c =>
        if (p.children(c) == null) p.children(c) = new Node(c)
        p = p.children(c)
      }
      p.terminate = true
    }

    def verify(word: String): Boolean = {
      var p = root
      word.forall { c =>
        val ans = p.children(c) != null && p.children(c).terminate
        // println(word, c, p.children(c), if (p.children(c) != null) p.children(c).terminate else "null")
        p = p.children(c)
        ans
      }
    }
  }

  def longestWord(words: Array[String]): String = {
    val trie = new Trie()
    words.foreach(word => trie.addWord(word))
    val sorted = words.sortWith { case (word1, word2) =>
      if (word1.length != word2.length) word1.length > word2.length
      else word1 < word2
    }
    sorted
      .collectFirst {
        case word if trie.verify(word) => word
      }
      .getOrElse("")
  }
}
