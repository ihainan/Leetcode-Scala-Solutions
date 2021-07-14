package me.ihainan

object P320 {
  def generateAbbreviations(word: String): List[String] = {
    val ans = collection.mutable.ListBuffer.empty[String]

    def solve(i: Int, prevNum: Boolean, str: String): Unit = {
      if (i == word.length) ans += str
      else {
        (i + 1 to word.length).foreach { next =>
          if (prevNum) solve(next, !prevNum, str + word.substring(i, next))
          else solve(next, !prevNum, str + (next - i).toString)
        }
      }
    }

    solve(0, true, "")
    solve(0, false, "")
    ans.toList
  }
}
