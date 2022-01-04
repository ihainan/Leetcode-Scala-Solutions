package me.ihainan

import collection.mutable.Map

object R1713 {

  class Node(c: Char) {
    val children = new Array[Node](26)
    var terminal = false
  }

  var root = new Node(' ')

  def addWord(word: String): Unit = {
    var p = root
    word.foreach { c =>
      if (p.children(c - 'a') == null) p.children(c - 'a') = new Node(c)
      p = p.children(c - 'a')
    }
    p.terminal = true
  }

  def findMatches(str: String, s: Int): List[Int] = {
    var p = root
    var i = s
    val ends = collection.mutable.ListBuffer.empty[Int]
    while (i < str.length && p != null) {
      val child = p.children(str(i) - 'a')
      if (child != null && child.terminal) ends += i
      i += 1
      p = child
    }
    ends.toList
  }

  def respace(dictionary: Array[String], sentence: String): Int = {
    root = new Node(' ')
    dictionary.foreach(word => addWord(word))
    solve(sentence, 0, Map.empty[Int, Int])
  }

  def solve(word: String, i: Int, map: Map[Int, Int]): Int = {
    if (map.isDefinedAt(i)) map(i)
    else if (i == word.length) 0
    else {
      val matches = findMatches(word, i)
      val skipMin = solve(word, i + 1, map) + 1
      val matchMin = if (matches.nonEmpty) matches.map { end => solve(word, end + 1, map) }.min
      else Int.MaxValue
      val ans = skipMin min matchMin
      map(i) = ans
      ans
    }
  }
}