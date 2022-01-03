package me.ihainan

object P1185 {
  def isLeapYear(y: Int): Boolean = y % 400 == 0 || (y % 4 == 0 && y % 100 != 0)

  def dayOfTheWeek(day: Int, month: Int, year: Int): String = {
    val strs = Array(
      "Sunday",
      "Monday",
      "Tuesday",
      "Wednesday",
      "Thursday",
      "Friday",
      "Saturday"
    )
    val set = Set(1, 3, 5, 7, 8, 10, 12)

    var days = day
    days += (1971 until year).map(y => if (isLeapYear(y)) 366 else 365).sum
    days += (1 until month).map { m =>
      if (set(m)) 31
      else if (m != 2) 30
      else if (isLeapYear(year)) 29
      else 28
    }.sum

    strs((days + 4) % 7)
  }
}
