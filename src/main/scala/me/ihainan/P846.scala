package me.ihainan

object P846 {
  def isNStraightHand(hand: Array[Int], groupSize: Int): Boolean = {
    if (hand.length % groupSize != 0) return false
    val sorted = hand.sorted
    val set = collection.mutable.Set.empty[Int]
    val map = collection.mutable.Map
      .empty[Int, Set[Int]]
      .withDefaultValue(Set.empty[Int])
    sorted.indices.foreach(i => map(sorted(i)) = map(sorted(i)) + i)
    sorted.indices.foreach { i =>
      if (!set(i)) {
        set += i
        map(sorted(i)) -= i
        (sorted(i) + 1 to sorted(i) + groupSize - 1).foreach { num =>
          if (map(num).isEmpty) return false
          else {
            val head = map(num).head
            set += head
            map(num) = map(num) - head
          }
        }
      }
    }
    true
  }
}
