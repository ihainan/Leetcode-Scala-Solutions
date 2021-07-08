package me.ihainan

object P1711 {
  def countPairs(deliciousness: Array[Int]): Int = {
    var ans = 0
    val MOD = 1000000007
    (0 to 21).foreach { i =>
      val target = math.pow(2, i).toInt
      val map = collection.mutable.Map.empty[Int, Int].withDefaultValue(0)
      deliciousness.foreach { d =>
        ans = (ans + map(target - d)) % MOD
        map(d) = map(d) + 1
      }
    }
    ans
  }
}