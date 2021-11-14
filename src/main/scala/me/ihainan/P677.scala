package me.ihainan

object P677 {
  import collection.mutable
  class MapSum() {
    val map = mutable.Map.empty[String, Int].withDefaultValue(0)

    class Trie {
      class Node(val c: Char) {
        val children = mutable.Map.empty[Char, Node].withDefaultValue(null)
        var terminate = false
      }

      private val root = new Node(' ')

      def addWord(word: String): Unit = {
        var p = root
        word.foreach { c =>
          if (p.children(c) == null) p.children(c) = new Node(c)
          p = p.children(c)
        }
        p.terminate = true
      }

      def sum(prefix: String): Int = {
        var ans = 0
        var p = root
        prefix.foreach { c =>
          if (p.children(c) == null) return 0 else p = p.children(c)
        }

        def dfs(node: Node, word: String): Unit = {
          if (node != null) {
            if (node.terminate) ans += map(word)
            node.children.foreach { case (k, v) => dfs(v, word + k) }
          }
        }

        dfs(p, prefix)
        ans
      }
    }

    private val trie = new Trie()

    def insert(key: String, `val`: Int): Unit = {
      trie.addWord(key)
      map(key) = `val`
    }

    def sum(prefix: String): Int = {
      trie.sum(prefix)
    }

  }

  /** Your MapSum object will be instantiated and called as such:
    * var obj = new MapSum()
    * obj.insert(key,`val`)
    * var param_2 = obj.sum(prefix)
    */
}
