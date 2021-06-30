package me.ihainan

object P171 {
  def titleToNumber(columnTitle: String): Int = {
    columnTitle.indices.map { i =>
      math.pow(26, columnTitle.length - i - 1).toInt * (columnTitle(i) - 'A' + 1)
    }.sum
  }
}