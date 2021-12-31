package me.ihainan

object P841 {
  def canVisitAllRooms(rooms: List[List[Int]]): Boolean = {
    val seen = collection.mutable.Set.empty[Int]

    def dfs(i: Int): Unit = {
      seen += i
      rooms(i).foreach { j =>
        if (!seen(j)) dfs(j)
      }
    }

    dfs(0)
    seen.size == rooms.size
  }
}
