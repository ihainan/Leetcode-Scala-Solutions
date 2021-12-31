package me.ihainan

object P507 {
  def checkPerfectNumber(num: Int): Boolean = {
    if (num == 1) return false
    var sum = 1
    (2 to math.sqrt(num).toInt).foreach { i =>
      if (num % i == 0) {
        sum += i
        if (i * i < num) sum += num / i
        if (sum > num) return false
      }
    }
    sum == num
  }
}