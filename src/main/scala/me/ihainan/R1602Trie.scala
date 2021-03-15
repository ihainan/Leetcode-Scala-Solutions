package me.ihainan

object R1602Trie {

  class WordsFrequency(_book: Array[String]) {

    class Node(val c: Char) {
      val children = new Array[Node](26)
      var times = 0
    }

    val root = new Node(' ')

    def insert(str: String): Unit = {
      var p = root
      str.foreach { c =>
        val num = c - 'a'
        if (p.children(num) == null) p.children(num) = new Node(c)
        p = p.children(num)
      }
      p.times += 1
    }

    _book.foreach { str => insert(str) }

    def get(word: String): Int = {
      var p = root
      word.foreach { c =>
        val num = c - 'a'
        if (p.children(num) == null) return 0
        else p = p.children(num)
      }
      p.times
    }

  }

  /**
    * Your WordsFrequency object will be instantiated and called as such:
    * var obj = new WordsFrequency(book)
    * var param_1 = obj.get(word)
    */
}