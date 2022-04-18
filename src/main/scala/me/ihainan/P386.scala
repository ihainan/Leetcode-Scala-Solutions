package me.ihainan

object P386 {

  def lexicalOrder(n: Int): List[Int] = {
    val ans = collection.mutable.ListBuffer.empty[Int]

    def dfs(current: Int): Unit = {
      ans += current
      (0 to 9).foreach { next =>
        if (current * 10 + next <= n) {
          dfs(current * 10 + next)
        }
      }
    }

    (1 to 9).foreach { i => if (i <= n) dfs(i) }
    ans.toList
  }
}
