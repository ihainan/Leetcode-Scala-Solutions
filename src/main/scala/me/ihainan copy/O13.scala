package me.ihainan

object O13 {
  val mx = Array(0, 1)
  val my = Array(1, 0)

  def digitalSum(num: Int): Int = {
    var (sum, n) = (0, num)
    while (n > 0) {
      sum += n % 10
      n /= 10
    }
    sum
  }

  def movingCount(m: Int, n: Int, k: Int): Int = {
    var ans = 0
    val queue = collection.mutable.Queue((0, 0))
    val set = collection.mutable.Set((0, 0))
    while (queue.nonEmpty) {
      val (x, y) = queue.dequeue
      ans += 1
      (0 until 2).foreach { i =>
        val nx = x + mx(i)
        val ny = y + my(i)
        if (!set((nx, ny)) && nx >= 0 && ny >= 0 && nx < m && ny < n && digitalSum(nx) + digitalSum(ny) <= k) {
          queue.enqueue((nx, ny))
          set += ((nx, ny))
        }
      }
    }
    ans
  }
}