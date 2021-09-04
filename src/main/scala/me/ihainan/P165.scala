package me.ihainan

object P165 {
  def compareVersion(version1: String, version2: String): Int = {
    val subVersion1 = version1.split("\\.")
    val subVersion2 = version2.split("\\.")

    (0 until subVersion1.length.max(subVersion2.length)).foreach { i =>
      val sv1 = if (i >= subVersion1.length) 0 else Integer.parseInt(subVersion1(i))
      val sv2 = if (i >= subVersion2.length) 0 else Integer.parseInt(subVersion2(i))
      if (sv1 > sv2) return 1
      if (sv1 < sv2) return -1
    }
    0
  }
}