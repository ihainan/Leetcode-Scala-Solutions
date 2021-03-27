package me.ihainan

import collection.mutable._

object R1707 {
  def trulyMostPopular(names: Array[String], synonyms: Array[String]): Array[String] = {
    val set = Set.empty[String]
    val pairs = synonyms.map { case synonym =>
      val nameA = synonym.substring(1, synonym.length - 1).split(",")(0)
      val nameB = synonym.substring(1, synonym.length - 1).split(",")(1)
      set += nameA
      set += nameB
      (nameA, nameB)
    }

    val nameToIndex = set.toArray.zip(0 until set.size).toMap
    val indexToName = nameToIndex.map(_.swap)
    val parents = (0 until set.size).toArray

    def find(i: Int): Int = {
      if (parents(i) == i) i
      else {
        parents(i) = find(parents(i))
        parents(i)
      }
    }

    def union(i: Int, j: Int): Unit = {
      val pi = find(i)
      val pj = find(j)
      if (pi != pj) {
        if (indexToName(pi) < indexToName(pj)) parents(pj) = pi
        else parents(pi) = pj
      }
    }

    pairs.foreach { case (nameA, nameB) => union(nameToIndex(nameA), nameToIndex(nameB)) }

    val ans = Map.empty[String, Int].withDefaultValue(0)
    names.foreach { nameAndNum =>
      val tmp = nameAndNum.substring(0, nameAndNum.length - 1)
      val name = tmp.split('(').apply(0)
      val num = tmp.split('(').apply(1)
      if (!nameToIndex.isDefinedAt(name)) ans(name) = ans(name) + num.toInt
      else {
        val parent = indexToName(find(nameToIndex(name)))
        ans(parent) = ans(parent) + num.toInt
      }
    }

    ans.map { case (k, v) => s"${k}(${v})" }.toArray
  }
}