package me.ihainan

import collection.mutable.{Map, ListBuffer}

object R1002 {
  def sortStr(str: String): String = {
    val arr = new Array[Int](26)
    str.foreach { c => arr(c - 'a') += 1 }
    val sb = new StringBuilder()
    (0 until 26).foreach { i => if (arr(i) != 0) sb.append(('a' + i) * arr(i)) }
    sb.toString
  }

  def groupAnagrams(strs: Array[String]): List[List[String]] = {
    val map = Map.empty[String, ListBuffer[String]].withDefaultValue(ListBuffer.empty[String])
    strs.foreach { str => val sorted = sortStr(str); map(sorted) = (map(sorted) :+ str) }
    map.keys.map { k => map(k).toList }.toList
  }
}