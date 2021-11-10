package me.ihainan

object P299 {
  def getHint(secret: String, guess: String): String = {
    var (bulls, cows) = (0, 0)
    val m1 = collection.mutable.Map.empty[Char, Int].withDefaultValue(0)
    val m2 = collection.mutable.Map.empty[Char, Int].withDefaultValue(0)
    secret.indices.foreach { i =>
      if (secret(i) == guess(i)) bulls += 1
      else {
        m1(secret(i)) = m1(secret(i)) + 1
        m2(guess(i)) = m2(guess(i)) + 1
      }
    }

    m1.keySet.foreach(k => cows += m1(k).min(m2(k)))
    bulls + "A" + cows + "B"
  }
}
