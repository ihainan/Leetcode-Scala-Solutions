package me.ihainan

object R0809 {
  def generateParenthesis(n: Int): List[String] = {
    solve(n, "", 0, 0)
  }

  def solve(n: Int, ans: String, lc: Int, rc: Int): List[String] = {
    if (lc > n || rc > n) Nil
    else if (lc == n && rc == n) List(ans)
    else {
      val left = solve(n, ans + "(", lc + 1, rc)
      val right = if (lc > rc) solve(n, ans + ")", lc, rc + 1) else Nil
      left ::: right
    }
  }
}