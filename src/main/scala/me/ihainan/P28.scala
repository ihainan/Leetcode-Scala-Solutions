package me.ihainan

object P28 {
  def strStr(haystack: String, needle: String): Int = {
    if (needle.isEmpty) 0
    else {
      val (len1, len2) = (haystack.length, needle.length)
      (0 to len1 - len2)
        .collectFirst {
          case i if !(0 until len2).exists { j =>
                haystack(j + i) != needle(j)
              } =>
            i
        }
        .getOrElse(-1)
    }
  }
}
