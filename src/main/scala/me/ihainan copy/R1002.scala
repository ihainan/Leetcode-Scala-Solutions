package me.ihainan

import collection.mutable.{Map, ListBuffer}

object R1002 {
  def sortString(str: String): String = {
    val chars = new Array[Int](26)
    str.foreach { c => chars(c - 'a') += 1 }
    val sb = new StringBuilder()
    chars.indices.foreach { i => (0 until chars(i)).foreach { _ => sb.append(('a' + i).toChar) } }
    sb.toString
  }

  def groupAnagrams(strs: Array[String]): List[List[String]] = {
    val map = collection.mutable.Map.empty[String, List[String]].withDefaultValue(Nil)
    strs.foreach { str =>
      val sorted = sortString(str);
      map(sorted) = map(sorted) :+ str
    }
    map.values.toList
  }
}