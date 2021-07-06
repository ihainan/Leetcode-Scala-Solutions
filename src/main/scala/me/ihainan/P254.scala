package me.ihainan

object P254 {
  def getFactors(n: Int): List[List[Int]] = {
    val ans = collection.mutable.ListBuffer.empty[List[Int]]

    def visit(num: Int, path: List[Int]): Unit = {
      var next = if (path.isEmpty) 2 else path.last
      while (next < num && num / next >= next) {
        if (num % next == 0) {
          ans += (path :+ next :+ (num / next))
          visit(num / next, path :+ next)
        }
        next += 1
      }
    }

    visit(n, Nil)
    ans.toList
  }
}