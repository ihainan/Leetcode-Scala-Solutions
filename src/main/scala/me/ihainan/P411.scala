package me.ihainan

object P411 {
  def isMatch(abbr: String, word: String): Boolean = {
    var (i, j) = (0, 0)
    while (i < abbr.length && j < word.length) {
      while (i < abbr.length && !Character.isDigit(abbr(i))) {
        if (j >= word.length || abbr(i) != word(j)) return false
        i += 1
        j += 1
      }
      var count = 0
      while (i < abbr.length && Character.isDigit(abbr(i))) {
        count = count * 10 + (abbr(i) - '0')
        i += 1
      }
      if (j + count - 1 >= word.length) return false
      else j += count
    }

    i == abbr.length && j == word.length
  }

  def minAbbreviation(target: String, dictionary: Array[String]): String = {
    var ans = ""

    def dfs(current: String, currentLen: Int, i: Int, isDigit: Boolean, len: Int): Boolean = {
      if (currentLen > len) false
      else if (currentLen == len) {
        if (i != target.length) false
        else {
          if (dictionary.exists(word => isMatch(current, word))) false
          else {
            ans = current
            true
          }
        }
      } else {
        if (isDigit) (i until target.length).exists(end => dfs(current + (end - i + 1).toString, currentLen + 1, end + 1, !isDigit, len))
        else (i until target.length).exists(end => dfs(current + target.substring(i, end + 1), currentLen + end - i + 1, end + 1, !isDigit, len))
      }
    }

    (1 to target.length).exists { len =>
      (0 to target.length).exists { end =>
        dfs(target.substring(0, end), end, end, true, len)
      }
    }

    ans
  }
}