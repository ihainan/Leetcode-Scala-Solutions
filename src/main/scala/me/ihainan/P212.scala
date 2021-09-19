package me.ihainan

object P212 {
  val mx = Array(0, 1, 0, -1)
  val my = Array(1, 0, -1, 0)

  class Node(val c: Char) {
    val children = collection.mutable.Map.empty[Char, Node]
    var terminate = false
  }

  class Trie {
    val root = new Node(' ')

    def addWord(word: String): Unit = {
      var p = root
      word.foreach { c =>
        if (!p.children.isDefinedAt(c)) p.children(c) = new Node(c)
        p = p.children(c)
      }
      p.terminate = true
    }
  }

  def findWords(
      board: Array[Array[Char]],
      words: Array[String]
  ): List[String] = {
    val (m, n) = (board.length, board.head.length)
    val ans = collection.mutable.ListBuffer.empty[String]
    val trie = new Trie()
    words.foreach(word => trie.addWord(word))

    def dfs(i: Int, j: Int, word: String, node: Node): Unit = {
      val c = board(i)(j)
      if (node.children.isDefinedAt(c)) {
        val next = node.children(c)
        val newWord = word + c
        if (next.terminate) ans += newWord
        board(i)(j) = '#'
        (0 until 4).foreach { k =>
          val (ni, nj) = (i + mx(k), j + my(k))
          if (ni >= 0 && ni < m && nj >= 0 && nj < n && board(ni)(nj) != '#')
            dfs(ni, nj, newWord, next)
        }
        board(i)(j) = c
      }
    }

    val root = trie.root
    (0 until m).foreach { i =>
      (0 until n).foreach { j =>
        dfs(i, j, "", root)
      }
    }

    ans.toList.distinct
  }
}
