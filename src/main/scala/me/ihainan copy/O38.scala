package me.ihainan

object O38 {

  class Trie {

    class Node(val c: Char) {
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

    def contains(word: String): Boolean = {
      var p = root
      word.foreach { c =>
        if (p.children(c - 'a') == null) return false
        p = p.children(c - 'a')
      }
      p.terminal
    }
  }

  def permutation(s: String): Array[String] = {
    val ans = collection.mutable.ArrayBuffer.empty[String]
    val visited = collection.mutable.Set.empty[Int]
    val arr = new Array[Char](s.length)

    val trie = new Trie()

    def visit(s: String, depth: Int): Unit = {
      if (depth == s.length) {
        val word = arr.mkString
        if (!trie.contains(word)) {
          ans += word
          trie.addWord(word)
        }
      } else {
        s.indices.foreach { i =>
          if (!visited(i)) {
            visited += i
            arr(depth) = s(i)
            visit(s, depth + 1)
            visited -= i
          }
        }
      }
    }

    visit(s, 0)
    ans.toArray
  }
}