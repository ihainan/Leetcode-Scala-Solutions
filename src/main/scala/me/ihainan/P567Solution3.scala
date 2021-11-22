package me.ihainan

object P567Solution3 {
  def checkInclusion(s1: String, s2: String): Boolean = {
    val (l1, l2) = (s1.length, s2.length)
    if (l1 > l2) return false
    val cnt = new Array[Int](26)
    s1.foreach(c => cnt(c - 'a') -= 1)
    var j = 0
    s2.indices.foreach { i =>
      val c = s2(i) - 'a'
      cnt(c) += 1
      while (cnt(c) > 0) {
        val c2 = s2(j) - 'a'
        cnt(c2) -= 1
        j += 1
      }

      if (i - j + 1 == l1) return true
    }

    false
  }
}
