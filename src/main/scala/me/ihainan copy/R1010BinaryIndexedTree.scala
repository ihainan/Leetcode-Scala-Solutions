package me.ihainan

object R1010BinaryIndexedTree {
  val tree = new Array[Int](50002)

  def track(x: Int) {
    var i = x + 1
    while (i <= 50001) {
      tree(i) += 1
      i += (i & -i)
    }
  }

  def getRankOfNumber(x: Int): Int = {
    var i = x + 1
    var sum = 0
    while (i > 0) {
      sum += tree(i)
      i -= (i & -i)
    }
    sum
  }
}

/**
  * Your StreamRank object will be instantiated and called as such:
  * var obj = new StreamRank()
  * obj.track(x)
  * var param_2 = obj.getRankOfNumber(x)
  */