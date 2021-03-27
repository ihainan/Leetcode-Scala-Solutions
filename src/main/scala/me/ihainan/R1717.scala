package me.ihainan

object R1717 {

  class Trie {

    class Node(val c: Char) {
      val children = new Array[Node](26)
      var terminal: Boolean = false
      var index = -1
    }

    val root = new Node(' ')

    def addWord(word: String, index: Int): Unit = {
      var p = root
      word.foreach { c =>
        if (p.children(c - 'a') == null) p.children(c - 'a') = new Node(c)
        p = p.children(c - 'a')
      }
      p.terminal = true
      p.index = index
    }

    def find(big: String, ans: Array[Array[Int]]): Unit = {
      big.indices.foreach { i =>
        var j = i
        var p = root
        while (j < big.length && p != null) {
          val c = big(j)
          val child = p.children(c - 'a')
          if (child != null && child.terminal) ans(child.index) = ans(child.index) :+ i
          j += 1
          p = child
        }
      }
    }
  }

  def multiSearch(big: String, smalls: Array[String]): Array[Array[Int]] = {
    val trie = new Trie()
    smalls.indices.foreach { i => trie.addWord(smalls(i), i) }
    val ans = Array.fill(smalls.length)(Array.empty[Int])
    trie.find(big, ans)
    ans
  }
}