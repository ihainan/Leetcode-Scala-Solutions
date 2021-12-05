package me.ihainan

object P242 {
  def isAnagram(s: String, t: String): Boolean = {
    if (s.length != t.length) return false
    val count = new Array[Int](26)
    s.indices.foreach { i =>
      count(s(i) - 'a') += 1
      count(t(i) - 'a') -= 1
    }
    !count.exists(c => c != 0)
  }
}
