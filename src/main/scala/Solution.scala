object Solution {
  def solve(n: Int): Int = {
    var dp = Array(0, 0, 1, 1)
    (1 until n).foreach { _ =>
      val tp = Array(dp(1), dp(2), dp(3), dp(0) + dp(1))
      dp = tp
    }
    dp(0)
  }

  def main(args: Array[String]): Unit = {
    (1 to 10).foreach(i => println(i, solve(i)))
  }
}