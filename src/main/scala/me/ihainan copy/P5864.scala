package me.ihainan

object P5864 {
  def numberOfWeakCharacters(properties: Array[Array[Int]]): Int = {
    val sorted = properties.sortWith { case (v1, v2) =>
      if (v1(0) != v2(0)) v1(0) > v2(0)
      else v1(1) < v2(1)
    }

    var max = 0
    sorted.count { case Array(a, d) =>
      val ans = d < max
      max = max.max(d)
      ans
    }
  }
}
