package me.ihainan

import collection.mutable.Map

object P913 {

  def catMouseGame(graph: Array[Array[Int]]): Int = {
    val n = graph.length
    val dp = Array.fill(n, n, 2 * n)(-1)
    val DRAW = 0
    val MOUSE_WIN = 1
    val CAT_WIN = 2

    def solve(mouse: Int, cat: Int, turns: Int): Int = {
      if (turns >= 2 * n) DRAW
      else {
        if (dp(cat)(mouse)(turns) == -1) {
          if (mouse == 0) dp(cat)(mouse)(turns) = MOUSE_WIN
          else if (cat == mouse) dp(cat)(mouse)(turns) = CAT_WIN
          else {
            val nextCatMove = turns % 2 == 1
            val currentPos = if (nextCatMove) cat else mouse
            var expectedResult = if (nextCatMove) MOUSE_WIN else CAT_WIN
            var drawExists = false
            graph(currentPos).foreach { next =>
              if (!(nextCatMove && next == 0)) {
                val nextMouse = if (nextCatMove) mouse else next
                val nextCat = if (nextCatMove) next else cat
                val result = solve(nextMouse, nextCat, turns + 1)
                if (result == DRAW) drawExists = true
                else if (result != expectedResult) {
                  // next move is cat and cat wins, or next move is mouse and mouse wins
                  dp(cat)(mouse)(turns) = result
                  return dp(cat)(mouse)(turns)
                }
              }
            }
            dp(cat)(mouse)(turns) = if (drawExists) DRAW else expectedResult
          }
        }
        // println(cat, mouse, turns, dp(cat)(mouse)(turns))
        dp(cat)(mouse)(turns)
      }
    }

    solve(1, 2, 0)
  }
}
