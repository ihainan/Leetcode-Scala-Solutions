object Solution extends App {
  def test(mask: Int): Unit = {
    var subset = mask

    while (subset != 0) {
      println(subset.toBinaryString)
      subset = (subset - 1) & mask
    }
  }

  test(Integer.parseInt("110101", 2))


}