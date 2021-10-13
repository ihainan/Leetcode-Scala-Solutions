package me.ihainan

object P412 {
  def fizzBuzz(n: Int): List[String] = {
    (1 to n).flatMap { i =>
      if (i % 15 == 0) Some("FizzBuzz")
      else if (i % 3 == 0) Some("Fizz")
      else if (i % 5 == 0) Some("Buzz")
      else Some(i.toString)
    }.toList
  }
}
