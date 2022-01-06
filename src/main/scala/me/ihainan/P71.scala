package me.ihainan

object P71 {
  def simplifyPath(path: String): String = {
    val ps = path.split("/")
    val ans = collection.mutable.ArrayDeque.empty[String]
    ps.foreach { str =>
      if (str != "." && str != "") {
        if (str == "..") {
          if (ans.length > 0) ans.removeLast()
        } else ans += str
      }
    }
    ans.mkString("/", "/", "")
  }
}