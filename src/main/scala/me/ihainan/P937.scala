package me.ihainan

object P937 {
  def reorderLogFiles(logs: Array[String]): Array[String] = {
    val idToContent = logs.map { str =>
      val head = str.split(" ").head
      (head, str.substring(head.length + 1))
    }
    val alphaList = idToContent
      .filter { case (_, content) =>
        content.head >= 'a' && content.head <= 'z'
      }
      .sortWith { case (v1, v2) =>
        if (v1._2 == v2._2) v2._1 >= v1._1
        else v2._2 >= v1._2
      }
      .map { case (id, content) => id + " " + content }
    val numList = idToContent
      .filter { case (_, content) =>
        content.head >= '0' && content.head <= '9'
      }
      .map { case (id, content) => id + " " + content }
    alphaList ++ numList
  }
}
