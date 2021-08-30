package me.ihainan

object P881 {
  def numRescueBoats(people: Array[Int], limit: Int): Int = {
    val visited = collection.mutable.Set.empty[Int]
    val sorted = people.sorted
    var i = sorted.length - 1
    var count = 0

    @annotation.tailrec
    def find(l: Int, r: Int, target: Int): Int = {
      if (l > r) -1
      else if (sorted(r) <= target) r
      else {
        val m = (l + r) >>> 1
        if (sorted(m) <= target) find(m, r - 1, target)
        else find(l, m - 1, target)
      }
    }

    while (visited.size != sorted.length) {
      while (i >= 0 && visited(i)) i -= 1
      if (i >= 0) visited += i
      var j = find(0, i - 1, limit - sorted(i))
      while (j >= 0 && visited(j)) j -= 1
      if (j >= 0) visited += j
      count += 1
    }

    count
  }
}