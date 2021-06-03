package me.ihainan

object O33 {
  def verifyPostorder(postorder: Array[Int]): Boolean = {
    def verify(l: Int, r: Int): Boolean = {
      if (l >= r) true
      else {
        var i = l
        while (i < r && postorder(i) < postorder(r)) i += 1
        var j = i
        while (j < r && postorder(j) > postorder(r)) j += 1
        j == r && verify(l, i - 1) && verify(i, r - 1)
      }
    }

    verify(0, postorder.length - 1)
  }
}