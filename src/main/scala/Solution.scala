object Solution {
  val MOD = 1000000007

  def numberOfUniqueGoodSubsequences(binary: String): Int = {
    val c0 = binary.count(_ == '0')
    val c1 = binary.count(_ == '1')
    // TODO: c0 == 0 or c1 == 0
    val dp = Array.fill(c1 + 1, c0 + 1, 4)(0)
    var ans = 0
    (0 to c1).foreach { i => dp(i)(0)(0) = i }
    (0 to c0).foreach { j => dp(0)(j)(3) = j }

    (0 to c1).foreach { i =>
      (0 to c0).foreach { j =>
        if (i != 0 && j != 0) {
          dp(i)(j)(0) = (dp(i - 1)(j)(0) + dp(i - 1)(j)(1)) % MOD // 1 x 1
          dp(i)(j)(1) = (dp(i)(j - 1)(0) + dp(i)(j - 1)(1)) % MOD // 0 x 1
          dp(i)(j)(2) = (dp(i - 1)(j)(2) + dp(i - 1)(j)(3)) % MOD // 1 x 0
          dp(i)(j)(3) = (dp(i)(j - 1)(2) + dp(i)(j - 1)(3)) % MOD // 0 x 0
        }
        println("==", i, j)
        println(dp(i)(j)(0), dp(i)(j)(2))
        ans += dp(i)(j)(0) + dp(i)(j)(2)
      }
    }
    ans
  }

  def main(args: Array[String]): Unit = {
    println(numberOfUniqueGoodSubsequences("101"))
  }
}