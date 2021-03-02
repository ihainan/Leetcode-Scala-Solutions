package me.ihainan

object R0807 {
  def permutation(S: String): Array[String] = {
    solve(S, 0, "", Set.empty[Char]).toArray
  }

  def solve(S: String, i: Int, ans: String, visited: Set[Char]): List[String] = {
    if (i == S.length) List(ans)
    else S.filter(c => !visited(c)).map(c => solve(S, i + 1, ans + c, visited + c)).reduce(_ ::: _)
  }
}