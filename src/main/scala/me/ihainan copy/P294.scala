package me.ihainan

object P294 {
  def canWin(currentState: String): Boolean = {
    def solve(current: String): Boolean = {
      if (!current.contains("++")) false
      else {
        val indices = (0 until currentState.length - 1).filter(i => current(i) == current(i + 1) && current(i) == '+')
        val states = indices.map(i => current.substring(0, i) + "--" + current.substring(i + 2, currentState.length))
        !states.exists { next => solve(next) }
      }
    }

    solve(currentState)
  }
}