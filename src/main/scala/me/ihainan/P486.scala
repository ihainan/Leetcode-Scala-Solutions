package me.ihainan

object P486 {

  def PredictTheWinner(nums: Array[Int]): Boolean = {
    def visit(l: Int, r: Int, diff: Int, turn: Boolean): Boolean = {
      if (l > r) diff >= 0
      else {
        if (turn) visit(l + 1, r, diff + nums(l), !turn) || visit(l, r - 1, diff + nums(r), !turn)
        else visit(l + 1, r, diff - nums(l), !turn) && visit(l, r - 1, diff - nums(r), !turn)
      }
    }

    visit(0, nums.length - 1, 0, true)
  }
}
