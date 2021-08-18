package me.ihainan

object P345 {
  def reverseVowels(s: String): String = {
    val chars = s.toCharArray
    val set = "aeiouAEIOU".toSet
    var (i, j) = (0, s.length - 1)
    while (i < j) {
      while (i < j && !set(chars(i))) i += 1
      while (i < j && !set(chars(j))) j -= 1
      val tmp = chars(i)
      chars(i) = chars(j)
      chars(j) = tmp
      i += 1
      j -= 1
    }
    new String(chars)
  }
}
