package me.ihainan

object R1722 {
  var ans: List[String] = Nil
  var memo = collection.mutable.Set.empty[String]

  def findLadders(beginWord: String, endWord: String, wordList: List[String]): List[String] = {
    ans = List.empty[String]
    memo.clear()
    val set = wordList.filter(_.length == endWord.length).toSet
    if (beginWord == endWord) List(beginWord)
    else if (!set(endWord)) List.empty[String]
    else {
      dfs(endWord, beginWord, set - beginWord, List(beginWord))
      ans
    }
  }

  def dfs(endWord: String, current: String, set: Set[String], path: List[String]): Unit = {
    if (ans == Nil && !memo(current)) {
      if (current == endWord) ans = path
      else {
        set.foreach { word =>
          if (word.zip(current).count { case (c1, c2) => c1 != c2 } == 1) {
            dfs(endWord, word, set - word, path :+ word)
          }
        }
        if (ans == Nil) memo += current
      }
    }
  }
}