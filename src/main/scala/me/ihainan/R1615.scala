package me.ihainan

object R1615 {
  def masterMind(solution: String, guess: String): Array[Int] = {
    var (m, n) = (0, 0)
    val times = new Array[Int](26)
    (0 until 4).foreach { i =>
      val (c1, c2) = (solution(i), guess(i))
      if (c1 == c2) m += 1
      else {
        if (times(c1 - 'A') < 0) n += 1
        times(c1 - 'A') += 1
        if (times(c2 - 'A') > 0) n += 1
        times(c2 - 'A') -= 1
      }
    }
    Array(m, n)
  }
}