package me.ihainan

object P1271 {
  def toHexspeak(num: String): String = {
    val hex = f"${num.toLong}%x"
    val chars = hex.map {
      case c if c == '0' => 'O'
      case c if c == '1' => 'I'
      case c if c >= 'a' && c <= 'f' => c.toUpper
      case c if c >= 'A' && c <= 'F' => c
      case _ => return "ERROR"
    }
    new String(chars)
  }
}