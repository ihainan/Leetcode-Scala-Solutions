package me.ihainan

object R1010 {
  val nums = new Array[Int](50001)

  def track(x: Int) {
    nums(x) += 1
  }

  def getRankOfNumber(x: Int): Int = {
    (0 to x).map(i => nums(i)).sum
  }

}

/**
  * Your StreamRank object will be instantiated and called as such:
  * var obj = new StreamRank()
  * obj.track(x)
  * var param_2 = obj.getRankOfNumber(x)
  */