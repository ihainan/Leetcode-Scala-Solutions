package me.ihainan

object P519 {
  class Solution(_m: Int, _n: Int) {
    val (m, n) = (_m, _n)
    var total = m * n
    val memo = collection.mutable.Map.empty[Int, Int]
    val random = new util.Random()

    def flip(): Array[Int] = {
      val next = random.nextInt(total)
      total -= 1
      val value = memo.getOrElse(next, next)
      memo(next) = memo.getOrElse(total, total)
      memo -= total
      Array(value / n, value % n)
    }

    def reset(): Unit = {
      memo.clear()
      total = m * n
    }

  }

  /** Your Solution object will be instantiated and called as such:
    * var obj = new Solution(m, n)
    * var param_1 = obj.flip()
    * obj.reset()
    */
}
