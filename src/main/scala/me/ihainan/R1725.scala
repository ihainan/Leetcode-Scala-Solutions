package me.ihainan

import collection.mutable.Map

object R1725 {

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

    def isMatch(words: Array[String], j: Int, maxDepth: Int, terminal: Boolean): Boolean = {
      var p = root
      var i = 0
      while (i < maxDepth && p != null) {
        val c = words(i)(j)
        val child = p.children(c - 'a')
        if (child == null) return false
        p = child
        i += 1
      }
      p != null && (!terminal || p.terminal)
    }
  }

  def maxRectangle(words: Array[String]): Array[String] = {
    val map = Map.empty[Int, Array[String]].withDefaultValue(Array.empty[String])
    words.foreach { word => map(word.length) = map(word.length) :+ word }
    val keys = map.keys.toArray.sortBy(k => -k)
    val tries = keys.map { k => val trie = new Trie(); map(k).foreach { word => trie.addWord(word) }; trie }
    keys.indices.foreach { i =>
      (i until keys.length).foreach { j =>
        val cols = keys(i)
        val rows = keys(j)
        val res = dfs(map(cols), 0, 0, Nil, rows, tries(j))
        if (res != Nil) return res.toArray
      }
    }

    Array.empty[String]
  }

  def dfs(words: Array[String], currentRows: Int, j: Int, path: List[String], rows: Int, trie: Trie): List[String] = {
    if (currentRows == rows) {
      if ((0 until words.head.length).exists(k => !trie.isMatch(path.toArray, k, path.length, terminal = true))) Nil
      else path
    } else {
      (j until words.length).foreach { k =>
        if ((0 until words.head.length).forall(l => trie.isMatch((path :+ words(k)).toArray, l, currentRows + 1, terminal = false))) {
          val res = dfs(words, currentRows + 1, j, path :+ words(k), rows, trie)
          if (res != Nil) return res
        }
      }
      Nil
    }
  }
}