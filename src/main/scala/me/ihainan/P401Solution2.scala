package me.ihainan

object P401Solution2 {
  def readBinaryWatch(turnedOn: Int): List[String] = {
    val ans = collection.mutable.ListBuffer.empty[String]

    (0 until 12).foreach { i =>
      (0 until 60).foreach { j =>
        if (i.toBinaryString.count(_ == '1') + j.toBinaryString.count(_ == '1') == turnedOn) {
          ans += f"$i:$j%02d"
        }
      }
    }

    ans.toList
  }
}