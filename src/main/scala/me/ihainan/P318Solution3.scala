package me.ihainan

object P318Solution3 {
  def maxProduct(words: Array[String]): Int = {
    val map = collection.mutable.Map.empty[Int, Int].withDefaultValue(0)
    words.foreach { word =>
      val num = word.map(c => 1 << (c - 'a')).reduce(_ | _)
      map(num) = map(num).max(word.length)
    }

    var ans = 0
    map.foreach { case (k1, v1) =>
      map.foreach { case (k2, v2) =>
        if ((k1 & k2) == 0) {
          ans = ans.max(v1 * v2)
        }
      }
    }
    ans
  }
}
