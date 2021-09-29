package me.ihainan

object P517 {
  def findMinMoves(machines: Array[Int]): Int = {
    val sum = machines.sum
    val len = machines.length
    val avg = sum / len
    if (sum % len != 0) return -1
    var (ls, rs) = (0, sum)
    var ans = 0
    machines.indices.foreach { i =>
      rs -= machines(i)
      val ld = 0.max(i * avg - ls)
      val rd = 0.max(avg * (len - i - 1) - rs)
      ans = ans.max(ld + rd)
      ls += machines(i)
    }
    ans
  }
}
