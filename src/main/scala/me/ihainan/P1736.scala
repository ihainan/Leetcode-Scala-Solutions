package me.ihainan

object P1736 {
  def maximumTime(time: String): String = {
    val (th, tm) = (time.substring(0, 2), time.substring(3, 5))

    (23 to 0 by -1).foreach { h =>
      val strH = f"$h%02d"
      if (strH == th || strH(0) + "?" == th || "?" + strH(1) == th || "??" == th) {
        (59 to 0 by -1).foreach { m =>
          val strM = f"$m%02d"
          if (strM == tm || strM(0) + "?" == tm || "?" + strM(1) == tm || "??" == tm) return strH + ":" + strM
        }
      }
    }
    ""
  }
}