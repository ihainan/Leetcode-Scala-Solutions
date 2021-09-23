package me.ihainan

object R1620Trie {
  class Node(val c: Char) {
    val children = new Array[Node](26)
    var terminal = false
  }

  val map = Array(
    Array('a', 'b', 'c'),
    Array('d', 'e', 'f'),
    Array('g', 'h', 'i'),
    Array('j', 'k', 'l'),
    Array('m', 'n', 'o'),
    Array('p', 'q', 'r', 's'),
    Array('t', 'u', 'v'),
    Array('w', 'x', 'y', 'z')
  )

  var root: Node = null

  def buildTree(i: Int, num: String, p: Node): Unit = {
    if (i == num.length) p.terminal = true
    else {
      // don't use toInt here
      map(num(i) - '0' - 2).foreach { j =>
        val v = j - 'a'
        if (p.children(v) == null) p.children(v) = new Node(j)
        buildTree(i + 1, num, p.children(v))
      }
    }
  }

  def find(i: Int, word: String, p: Node): Boolean = {
    if (p == null) false
    else if (i == word.length) p.terminal
    else find(i + 1, word, p.children(word(i) - 'a'))
  }

  def getValidT9Words(num: String, words: Array[String]): List[String] = {
    root = new Node(' ')
    buildTree(0, num, root)
    words.filter { word => find(0, word, root) }.toList
  }
}