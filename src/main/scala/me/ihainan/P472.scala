package me.ihainan

object P472 {
  class Trie {
    class Node(c: Char) {
      val children =
        collection.mutable.Map.empty[Char, Node].withDefaultValue(null)
      var terminate = false
    }

    val root = new Node(' ')

    def addWord(w: String): Unit = {
      var p = root
      w.foreach { c =>
        if (p.children(c) == null) p.children(c) = new Node(c)
        p = p.children(c)
      }
      p.terminate = true
    }

    def find(w: String, s: Int): List[Int] = {
      var p = root
      val ans = collection.mutable.ListBuffer.empty[Int]
      (s until w.length).foreach { i =>
        if (p.children(w(i)) == null) return ans.toList
        else {
          p = p.children(w(i))
          if (p.terminate) ans += i
        }
      }
      ans.toList
    }
  }

  def findAllConcatenatedWordsInADict(words: Array[String]): List[String] = {
    val sorted = words.sortBy(_.length)
    val trie = new Trie()
    sorted.filter { str =>
      if (str.length == 0) false
      else {
        val dp = new Array[Boolean](str.length)
        str.indices.foreach { i =>
          if (i == 0 || dp(i - 1)) {
            trie.find(str, i).foreach(j => dp(j) = true)
          }
        }
        if (!dp.last) trie.addWord(str)
        dp.last
      }
    }.toList
  }
}
