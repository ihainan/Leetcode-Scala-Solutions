package me.ihainan

object P1711Solution2 {
  def countPairs(deliciousness: Array[Int]): Int = {
    var ans = 0
    val MOD = 1000000007
    val map = collection.mutable.Map.empty[Int, Int].withDefaultValue(0)
    val targets = (0 to 21).map(i => math.pow(2, i).toInt)
    deliciousness.foreach { d =>
      targets.foreach { target => ans = (ans + map(target - d)) % MOD }
      map(d) = map(d) + 1
    }

    ans
  }
}