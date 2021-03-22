package me.ihainan

object P370 {
  def getModifiedArray(length: Int, updates: Array[Array[Int]]): Array[Int] = {
    val diff = new Array[Int](length + 1)
    updates.foreach { update =>
      diff(update(0)) += update(2)
      diff(update(1) + 1) -= update(2)
    }

    var tmp = 0
    (0 until length).map { i => val d = diff(i); tmp += d; tmp }.toArray
  }
}