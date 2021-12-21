package me.ihainan

object P1518 {
  def numWaterBottles(numBottles: Int, numExchange: Int): Int = {
    var num = numBottles
    var count = numBottles
    while (num >= numExchange) {
      count += num / numExchange
      num = num % numExchange + num / numExchange
    }
    count
  }
}