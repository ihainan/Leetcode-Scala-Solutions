package me.ihainan

object P1244 {
  case class Item(id: Int, score: Int)

  val map = collection.mutable.Map.empty[Int, Item]

  def addScore(playerId: Int, score: Int) {
    if (map.isDefinedAt(playerId)) map(playerId) = Item(playerId, map(playerId).score + score)
    else map(playerId) = Item(playerId, score)
  }

  def top(K: Int): Int = {
    val nums = map.values.toArray
    quickFind(nums, 0, nums.length - 1, K - 1)
    (0 until K).map(i => nums(i).score).sum
  }

  def swap[T](nums: Array[T], i: Int, j: Int): Unit = {
    val tmp = nums(i)
    nums(i) = nums(j)
    nums(j) = tmp
  }

  def quickFind(nums: Array[Item], l: Int, r: Int, k: Int): Unit = {
    if (l < r) {
      val tmp = nums(l).score
      var (i, j) = (l, r)
      while (i < j) {
        while (i < j && nums(j).score < tmp) j -= 1
        while (i < j && nums(i).score >= tmp) i += 1
        swap(nums, i, j)
      }
      swap(nums, l, i)
      if (i > k) quickFind(nums, l, i - 1, k)
      else if (i < k) quickFind(nums, i + 1, r, k)
    }
  }

  def reset(playerId: Int) {
    map -= playerId
  }

}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * var obj = new Leaderboard()
 * obj.addScore(playerId,score)
 * var param_2 = obj.top(K)
 * obj.reset(playerId)
 */