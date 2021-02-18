object Solution1 {
  // O(N * N)
  def oneEditAway(first: String, second: String): Boolean = {
    val l1 = first.length
    val l2 = second.length
    val dp = Array.fill(l1 + 1, l2 + 1)(Int.MaxValue)
    (0 to l1).foreach { i => dp(i)(0) = i }
    (0 to l2).foreach { i => dp(0)(i) = i }
    (1 to l1).foreach { i =>
      (1 to l2).foreach { j =>
        val v = if (first(i - 1) == second(j - 1)) 0 else 1
        dp(i)(j) = dp(i)(j).min(dp(i - 1)(j) + 1).min(dp(i)(j - 1) + 1).min(dp(i - 1)(j - 1) + v)
      }
    }

    dp(l1)(l2) <= 1
  }
}
