package me.ihainan

object P269 {
  def alienOrder(words: Array[String]): String = {
    val map = collection.mutable.Map.empty[Char, Set[Char]].withDefaultValue(Set.empty[Char])
    val in = collection.mutable.Map.empty[Char, Int].withDefaultValue(0)
    words.flatMap(k => k).toSet.foreach { k: Char => in(k) = 0 }
    
    (0 until words.length - 1).foreach { i =>
      (i + 1 until words.length).foreach { j =>
        val (w1, w2) = (words(i), words(j))
        if (w1.startsWith(w2) && w1.length > w2.length) return ""
        else if (!(w2.startsWith(w1))) {
          val k = (0 until w1.length.min(w2.length)).collectFirst { case k if w1(k) != w2(k) => k }.getOrElse(return "")
          if (!map(w1(k))(w2(k))) in(w2(k)) = in(w2(k)) + 1
          map(w1(k)) = map(w1(k)) + (w2(k))
        }
      }
    }

    val ans = new StringBuilder()
    while (in.nonEmpty) {
      val zeros = in.keySet.filter(k => in(k) == 0).toArray
      if (zeros.length == 0) return ""
      val toRemove = zeros.head
      ans.append(toRemove)
      map(toRemove).foreach { next => in(next) = in(next) - 1 }
      in -= toRemove 
    }

    ans.toString
  }
}