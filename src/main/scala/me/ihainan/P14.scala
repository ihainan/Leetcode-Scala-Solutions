package me.ihainan

object P14 {
  def longestCommonPrefix(strs: Array[String]): String = {
    if (strs.isEmpty) ""
    else {
      val maxLen = (0 until strs.head.length).collectFirst {
        case i if {
          val c = strs.head.apply(i);
          strs.exists { str => str.length == i || str(i) != c }
        } => i
      }.getOrElse(strs.head.length)
      strs.head.substring(0, maxLen)
    }
  }
}