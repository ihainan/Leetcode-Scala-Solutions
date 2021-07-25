package me.ihainan

object P1086Solution2 {
  def highFive(items: Array[Array[Int]]): Array[Array[Int]] = {
    val map = collection.mutable.Map.empty[Int, List[Int]].withDefaultValue(Nil)
    items.foreach { item => map(item(0)) = map(item(0)) :+ item(1) }

    map.keys.toArray.sorted.map { k =>
      val sorted = map(k).toArray.sorted.reverse
      Array(k, (0 until 5).map(i => sorted(i)).sum / 5)
    }
  }
}