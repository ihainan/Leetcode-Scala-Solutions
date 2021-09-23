package me.ihainan

object O66 {
  def constructArr(a: Array[Int]): Array[Int] = {
    var tmp = 1
    val leftToRight = a.map { num => tmp *= num; tmp }
    tmp = 1
    val rightToLeft = a.reverse.map { num => tmp *= num; tmp }.reverse

    a.indices.map { i =>
      val left = if (i == 0) 1 else leftToRight(i - 1)
      val right = if (i == a.length - 1) 1 else rightToLeft(i + 1)
      left * right
    }.toArray
  }
}