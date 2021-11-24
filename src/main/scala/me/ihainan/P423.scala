package me.ihainan

object P423 {
  def originalDigits(s: String): String = {
    val map = collection.mutable.Map.empty[Char, Int].withDefaultValue(0)
    s.foreach(c => map(c) += 1)
    val cnt = new Array[Int](10)

    cnt(0) = map('z')
    cnt(2) = map('w')
    cnt(4) = map('u')
    cnt(6) = map('x')
    cnt(8) = map('g')

    cnt(3) = map('h') - cnt(8)
    cnt(7) = map('s') - cnt(6)
    cnt(5) = map('f') - cnt(4)

    cnt(1) = map('o') - cnt(0) - cnt(2) - cnt(4)
    cnt(9) = map('i') - cnt(5) - cnt(6) - cnt(8)

    cnt.indices.map(i => if (cnt(i) == 0) "" else i.toString * cnt(i)).mkString
  }
}
