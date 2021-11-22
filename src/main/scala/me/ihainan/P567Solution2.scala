package me.ihainan

object P567Solution2 {
  def checkInclusion(s1: String, s2: String): Boolean = {
    if (s1.length > s2.length) return false
    val cnt = new Array[Int](26)
    s1.indices.foreach { i =>
      cnt(s1(i) - 'a') += 1
      cnt(s2(i) - 'a') -= 1
    }

    var diff = cnt.count(_ != 0)
    if (diff == 0) return true

    (s1.length until s2.length).foreach { i =>
      val (c1, c2) = (s2(i - s1.length) - 'a', s2(i) - 'a')
      if (cnt(c1) == 0) diff += 1
      cnt(c1) += 1
      if (cnt(c1) == 0) diff -= 1
      if (cnt(c2) == 0) diff += 1
      cnt(c2) -= 1
      if (cnt(c2) == 0) diff -= 1
      if (diff == 0) return true
    }

    false
  }
}
