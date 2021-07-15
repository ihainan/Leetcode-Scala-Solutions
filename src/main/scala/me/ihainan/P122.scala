package me.ihainan

object P122 {
  def maxProfit(prices: Array[Int]): Int = {
    (1 until prices.length).map { i => 0.max(prices(i) - prices(i - 1)) }.sum
  }
}