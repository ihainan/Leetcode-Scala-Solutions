package me.ihainan

object P470Solution {
  def rand10(): Int = {
    var r = (rand7() - 1) * 7 + rand7()
    while (r > 40) r = (rand7() - 1) * 7 + rand7()
    (r % 10) + 1
  }
}