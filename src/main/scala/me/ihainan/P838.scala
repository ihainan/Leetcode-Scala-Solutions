package me.ihainan

object P838 {
  def pushDominoes(dominoes: String): String = {
    var tmp = -1
    val nearRight = dominoes.indices.map { i =>
      val direction = dominoes(i)
      if (direction == '.') tmp
      else {
        if (direction == 'R') tmp = i
        else tmp = -1
        -1
      }
    }
    tmp = -1
    val nearLeft = (dominoes.length - 1 to 0 by -1).map { i =>
      val direction = dominoes(i)
      if (direction == '.') tmp
      else {
        if (direction == 'L') tmp = i
        else tmp = -1
        -1
      }
    }.reverse  

    dominoes.indices.map { i =>
      val direction = dominoes(i)
      val distanceR = if (nearRight(i) == -1) Int.MaxValue else i - nearRight(i)
      val distanceL = if (nearLeft(i) == -1) Int.MaxValue else nearLeft(i) - i
      if (direction == 'L' || direction == 'R') direction
      else if (distanceL == distanceR) '.'
      else if (distanceL < distanceR) 'L'
      else 'R'
    }.mkString
  }
}