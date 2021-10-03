package me.ihainan

object P118 {
  def generate(numRows: Int): List[List[Int]] = {
    val ans = new Array[List[Int]](numRows)
    (0 until numRows).foreach { i =>
      ans(i) = (0 to i).map { j =>
        if (j == 0 || j == i) 1
        else ans(i - 1)(j - 1) + ans(i - 1)(j)
      }.toList
    }
    ans.toList
  }
}
