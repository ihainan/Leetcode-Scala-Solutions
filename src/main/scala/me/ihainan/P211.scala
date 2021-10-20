package me.ihainan

object P211 {
  class WordDictionary() {
    import collection.mutable

    class Node(val char: Char) {
      val children = mutable.Map.empty[Char, Node].withDefaultValue(null)
      var isTerminate = false
    }

    val root = new Node(' ')

    def addWord(word: String) {
      var p = root
      word.foreach { c =>
        if (p.children(c) == null) p.children(c) = new Node(c)
        p = p.children(c)
      }
      p.isTerminate = true
    }

    def dfs(node: Node, i: Int, word: String): Boolean = {
      if (node == null) false
      else if (i == word.length) node.isTerminate
      else if (word(i) == '.') node.children.exists { case (k, v) =>
        dfs(v, i + 1, word)
      }
      else dfs(node.children(word(i)), i + 1, word)
    }

    def search(word: String): Boolean = {
      dfs(root, 0, word)
    }

  }

  /** Your WordDictionary object will be instantiated and called as such: var
    * obj = new WordDictionary() obj.addWord(word) var param_2 =
    * obj.search(word)
    */
}
