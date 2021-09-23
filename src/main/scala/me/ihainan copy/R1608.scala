package me.ihainan

object R1608 {
  val LESS_THAN_TWENTY: Array[String] = Array(
    "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
    "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
  )

  val DECADES: Array[String] = Array("", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety")

  val UNITS: Array[String] = Array("", " Thousand", " Million", " Billion")

  def numberToWords(num: Int): String = {
    if (num == 0) "Zero"
    else {
      var ans = List.empty[String]
      var cur = 0
      var n = num
      while (n > 0) {
        if (n % 1000 > 0) ans = (lessThanOneThousand(n % 1000) + UNITS(cur)) :: ans
        n /= 1000
        cur += 1
      }
      ans.mkString(" ")
    }
  }

  def lessThanOneThousand(num: Int): String = {
    val ans = collection.mutable.ListBuffer.empty[String]

    if (num / 100 > 0) ans += LESS_THAN_TWENTY(num / 100) + " Hundred"
    if (num % 100 > 0) {
      if (num % 100 < 20) ans += LESS_THAN_TWENTY(num % 100)
      else if (num % 10 == 0) ans += DECADES((num % 100) / 10)
      else ans += DECADES((num % 100) / 10) + " " + LESS_THAN_TWENTY(num % 10)
    }

    ans.mkString(" ")
  }
}