package me.ihainan

object P293 {
  def generatePossibleNextMoves(currentState: String): List[String] = {
    (0 until currentState.length - 1).flatMap { i =>
      if (currentState(i) != currentState(i + 1) || currentState(i) != '+') None
      else Some(currentState.substring(0, i) + "--" + currentState.substring(i + 2, currentState.length))
    }.toList
  }
}