package me.ihainan

object P202 {
  def isHappy(n: Int): Boolean = {
    var nn = n
    val set = collection.mutable.Set.empty[Int]
    while (!set(nn) && nn != 1) {
      set += nn
      var tmp = 0
      while (nn != 0) {
        tmp += (nn % 10) * (nn % 10)
        nn /= 10
      }
      nn = tmp
    }
    nn == 1
  }
}
