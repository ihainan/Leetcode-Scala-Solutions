package me.ihainan

object P271 {

  class Codec {
    // Encodes a list of strings to a single string.
    def encode(strs: List[String]): String = {
      strs.map(_.map(c => f"$c%2x").mkString).mkString(",")
    }

    // Decodes a single string to a list of strings.
    def decode(s: String): List[String] = {
      val nums = s.split(",", -1)
      nums.map { numStr =>
        val chars = (0 until numStr.length by 2).map { i => Integer.parseInt(numStr.substring(i, i + 2), 16).toChar }.toArray
        new String(chars)
      }.toList
    }
  }

}