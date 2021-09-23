package me.ihainan

object P789 {
  def escapeGhosts(ghosts: Array[Array[Int]], target: Array[Int]): Boolean = {
    val distance = target(0).abs + target(1).abs
    !ghosts.exists(ghost => (ghost(0) - target(0)).abs + (ghost(1) - target(1)).abs <= distance)
  }
}