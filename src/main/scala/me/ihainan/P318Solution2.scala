package me.ihainan

object P318Solution2 {
  def maxProduct(words: Array[String]): Int = {
    val nums = words.map { word =>
      word.map(c => 1 << (c - 'a')).reduce(_ | _)
    }

    var ans = 0
    (0 until words.length - 1).foreach { i =>
      (i + 1 until words.length).foreach { j =>
        if ((nums(i) & nums(j)) == 0) {
          ans = ans.max(words(i).length * words(j).length)
        }
      }
    }
    ans
  }
}