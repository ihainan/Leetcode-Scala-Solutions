package me.ihainan

object P125 {
  def isPalindrome(s: String): Boolean = {
    var (i, j) = (0, s.length - 1)
    while (i < j) {
      while (i < j && !Character.isLetterOrDigit(s(i))) i += 1
      while (i < j && !Character.isLetterOrDigit(s(j))) j -= 1
      if (Character.toLowerCase(s(i)) != Character.toLowerCase(s(j)))
        return false
      i += 1
      j -= 1
    }
    true
  }
}
