package me.ihainan

object O46 {

  object Solution {
    def translateNum(num: Int): Int = {
      val str = num.toString
      val set = collection.mutable.Set.empty[String]
      val map = (0 until 26).map(i => (i, ('a' + i).toChar)).toMap
      var ans = 0

      def dfs(depth: Int, current: String): Unit = {
        if (depth == str.length) {
          if (!set(current)) {
            set += current
            ans += 1
            println(current)
          }
        } else {
          dfs(depth + 1, current + map(str(depth) - '0'))
          if (depth != str.length - 1) {
            val nextTwoCharsToInt = str.substring(depth, depth + 2).toInt
            if (nextTwoCharsToInt <= 25 && nextTwoCharsToInt >= 10) dfs(depth + 2, current + map(nextTwoCharsToInt))
          }
        }
      }

      dfs(0, "")
      ans
    }
  }