package me.ihainan

object P911 {
  class TopVotedCandidate(_persons: Array[Int], _times: Array[Int]) {
    val count = new Array[Int](_persons.length)
    var top = 0
    val map = collection.mutable.Map.empty[Int, Int]
    _persons.indices.foreach { i =>
      count(_persons(i)) += 1
      if (count(_persons(i)) >= count(_persons(top))) top = i
      map(_times(i)) = _persons(top)
    }

    @annotation.tailrec
    private def find(l: Int, r: Int, t: Int): Int = {
      if (l > r) -1
      else if (_times(r) <= t) r
      else {
        val m = (l + r) >>> 1
        if (_times(m) <= t) find(m, r - 1, t) else find(l, m - 1, t)
      }
    }

    def q(t: Int): Int = {
      val index = find(0, _times.length - 1, t)
      map(_times(index))
    }

  }

  /** Your TopVotedCandidate object will be instantiated and called as such:
    * var obj = new TopVotedCandidate(persons, times)
    * var param_1 = obj.q(t)
    */

}
