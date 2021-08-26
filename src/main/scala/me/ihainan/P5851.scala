package me.ihainan

object P5851 {
  def findDifferentBinaryString(nums: Array[String]): String = {
    val set = nums.toSet
    var ans = ""

    def dfs(str: String): Unit = {
      if (ans == "") {
        if (str.length == nums.head.length) {
          if (!set(str)) ans = str
        } else {
          dfs(str + "0")
          dfs(str + "1")
        }
      }
    }

    dfs("")
    ans
  }
}
