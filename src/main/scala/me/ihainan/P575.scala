package me.ihainan

object P575 {
  def distributeCandies(candyType: Array[Int]): Int = {
    val map = collection.mutable.Map.empty[Int, Int].withDefaultValue(0)
    candyType.foreach(t => map(t) = map(t) + 1)
    (candyType.length / 2).min(map.size)
  }
}
