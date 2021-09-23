package me.ihainan

object P881Solution2 {
  def numRescueBoats(people: Array[Int], limit: Int): Int = {
    val visited = collection.mutable.Set.empty[Int]
    val sorted = people.sorted
    var (i, j) = (0, sorted.length - 1)
    var count = 0
    while (i <= j) {
      if (sorted(i) + sorted(j) <= limit) i += 1
      j -= 1
      count += 1
    }
    count
  }
}