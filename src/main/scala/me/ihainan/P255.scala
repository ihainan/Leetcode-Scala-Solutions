package me.ihainan

object P255 {
  def verifyPreorder(preorder: Array[Int]): Boolean = {

    def verify(l: Int, r: Int): Boolean = {
      if (l >= r - 1) true
      else {
        var i = l + 1
        while (i <= r && preorder(i) < preorder(l)) i += 1
        if (!verify(l + 1, i - 1)) false
        else if (i == r + 1) true
        else {
          var j = i
          while (j <= r && preorder(j) > preorder(l)) j += 1
          j == r + 1 && verify(i, r)
        }
      }
    }

    verify(0, preorder.length - 1)
  }
}