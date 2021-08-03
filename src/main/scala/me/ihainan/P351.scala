package me.ihainan

object P351 {
  val neighbors: Array[Set[Int]] = (0 until 9).map { i =>
    (0 until 9).filter { j => !((j / 3 - i / 3).abs > 1) && !((j % 3 - i % 3).abs > 1) }.toSet
  }.toArray

  def numberOfPatterns(m: Int, n: Int): Int = {
    var ans = 0

    def visit(path: Set[Int], current: Int, tmp: List[Int]): Unit = {
      if (path.size <= n) {
        if (path.size >= m) ans += 1

        val (x, y) = (current / 3, current % 3)
        (0 until 9).foreach { next =>
          if (!path(next)) {
            val (nx, ny) = (next / 3, next % 3)
            var flag = false
            if (neighbors(current)(next)) flag = true
            else {
              if (x != nx && y != ny && (x - nx).abs != (y - ny).abs) flag = true
              else flag = path((x + nx) / 2 * 3 + (y + ny) / 2)
            }
            if (flag) visit(path + next, next, tmp :+ next)
          }
        }
      }
    }

    (0 until 9).foreach { current => visit(Set(current), current, List(current)) }

    ans
  }
}