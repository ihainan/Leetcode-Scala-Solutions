package me.ihainan

object P1716 {
  def totalMoney(n: Int): Int = {
    28 * (n / 7) + (7 + 7 * (n / 7 - 1)) * (n / 7 - 1) / 2 + (n / 7 + 1 + n / 7 + n % 7) * (n % 7) / 2
  }
}
