package me.ihainan

object O57II {
  def findContinuousSequence(target: Int): Array[Array[Int]] = {
    val ans = collection.mutable.ArrayBuffer.empty[Array[Int]]
    (1 to target).foreach { a =>
      val b = calculate(a.toDouble, target)
      if (b > a && b == b.toInt && b != a) {
        ans += (a to b.toInt).toArray
      }
    }
    ans.toArray
  }

  def calculate(a: Double, target: Int): Double = {
    (-1 + math.sqrt(1 - 4 * (a - a * a - 2 * target))) / 2
  }
}