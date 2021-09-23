package me.ihainan

object P89Solution2 {
  def grayCode(n: Int): List[Int] = {
    var ans = List(0, 1)
    (2 to n).foreach { i =>
      ans = ans ::: ans.reverse.map(num => num | (1 << (i - 1)))
    }
    ans
  }
}