package me.ihainan

object P1629 {
  def slowestKey(releaseTimes: Array[Int], keysPressed: String): Char = {
    var ans = 0
    var ansKey = 'a'
    releaseTimes.indices.foreach { i =>
      val time = releaseTimes(i) - (if (i == 0) 0 else releaseTimes(i - 1))
      if (time > ans || (time == ans && keysPressed(i) > ansKey)) {
        ansKey = keysPressed(i)
        ans = time
      }
    }
    ansKey
  }
}