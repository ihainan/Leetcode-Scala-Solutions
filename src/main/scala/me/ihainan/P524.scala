package me.ihainan

object P524 {
  def isSubtring(s1: String, s2: String): Boolean = {
      if (s2.length > s1.length) return false
      var i = 0
      s2.foreach { c =>
        while (i < s1.length && s1(i) != c) i += 1
        if (i == s1.length) return false
        i += 1
      }
      true
    }

    def findLongestWord(s: String, dictionary: List[String]): String = {
      val sorted = dictionary.sortWith { case (v1, v2) =>
        if (v1.length != v2.length) v1.length > v2.length
        else v1 < v2
      }

      sorted.collectFirst {
        case s2 if isSubtring(s, s2) => s2
      }.getOrElse("")
    }
  }