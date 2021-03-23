package me.ihainan

object R1708Better {
  def bestSeqAtIndex(height: Array[Int], weight: Array[Int]): Int = {
    if (height.length == 0) 0
    else {
      val sorted = height.zip(weight).sortWith { case (p1, p2) =>
        if (p1._1 == p2._1) p1._2 > p2._2
        else p1._1 < p2._1
      }

      val d = new Array[Int](sorted.length + 1)
      var len = 1
      d(len) = sorted(0)._2

      (1 until sorted.length).foreach { i =>
        if (sorted(i)._2 > d(len)) {
          len += 1
          d(len) = sorted(i)._2
        } else {
          val j = find(1, len, sorted(i)._2, d)
          d(j) = sorted(i)._2
        }
      }

      len
    }
  }

  @scala.annotation.tailrec
  def find(l: Int, r: Int, num: Int, dp: Array[Int]): Int = {
    if (l > r) 1
    else if (dp(l) >= num) l
    else {
      val mid = (l + r) >>> 1
      if (dp(mid) < num) find(mid + 1, r, num, dp)
      else find(l + 1, mid, num, dp)
    }
  }
}