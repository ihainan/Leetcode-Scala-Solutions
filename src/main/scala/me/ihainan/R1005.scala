package me.ihainan

import scala.collection.mutable.{ListBuffer, Map}

object R1005 {
  def findString(words: Array[String], s: String): Int = {
    find(0, words.length - 1, words, s)
  }

  def find(l: Int, r: Int, words: Array[String], s: String): Int = {
    if (l > r) -1
    else {
      val mid = (l + r) / 2
      if (words(mid) == "") {
        val left = find(l, mid - 1, words, s)
        if (left != -1) left
        else find(mid + 1, r, words, s)
      } else if (words(mid) == s) mid
      else if (words(mid) > s) find(l, mid - 1, words, s)
      else find(mid + 1, r, words, s)
    }
  }
}