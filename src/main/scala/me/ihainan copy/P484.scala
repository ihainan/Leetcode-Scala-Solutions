package me.ihainan

object P484 {
  def findPermutation(s: String): Array[Int] = {
    val ans = new Array[Int](s.length + 1)
    var i = s.length - 1
    var largest = s.length + 1
    def getLargest: Int = {
      largest -= 1
      largest + 1
    }

    while (i >= 0) {
      var j = i
      if (s(i) == 'I') {
        if (i == s.length - 1) ans(s.length) = getLargest
        while (j >= 0 && s(j) == 'I') j -= 1
        (i - 1 to j + 1 by -1).foreach(k => ans(k + 1) = getLargest)
        if (j == -1) ans(0) = getLargest
      } else {
        while (j >= 0 && s(j) == 'D') j -= 1
        (j to i).foreach(k => ans(k + 1) = getLargest)
      }
      i = j
    }

    ans
  }
}
