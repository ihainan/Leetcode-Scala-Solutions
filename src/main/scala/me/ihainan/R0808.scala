package me.ihainan

object R0808 {
  def permutation(S: String): Array[String] = {
    val map = Map.empty[Char, Int].withDefaultValue(0)
    S.foreach(c => map(c) = map(c) + 1)
    solve(S, 0, "", map).toArray
  }

  def solve(S: String, i: Int, ans: String, map: Map[Char, Int]): List[String] = {
    if (i == S.length) List(ans)
    else {
      map.keys.filter(k => map(k) > 0).map { k =>
        map(k) = map(k) - 1
        val tmp = solve(S, i + 1, ans + k, map)
        map(k) = map(k) + 1
        tmp
      }.reduce(_ ::: _)
    }
  }
}