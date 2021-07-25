package me.ihainan

object P1118 {
  def numberOfDays(Y: Int, M: Int): Int = {
    val set = Set(1, 3, 5, 7, 8, 10, 12)

    if (M == 2 && ((Y % 100 != 0 && Y % 4 == 0)) || Y % 400 == 0) 29
    else if (M == 2) 28
    else if (set(M)) 31
    else 30
  }
}