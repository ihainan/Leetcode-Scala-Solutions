package me.ihainan.utils

object ToArray {
  def main(args: Array[String]): Unit = {
     val input = args(0)
     println(input.replace("[", "Array(").replace("]", ")"))
  }
}