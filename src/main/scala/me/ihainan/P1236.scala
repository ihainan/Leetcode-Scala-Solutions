package me.ihainan

object P1236 {

  // This is the HtmlParser's API interface.
  // You should not implement it, or speculate about its implementation
  class HtmlParser {
    def getUrls(url: String): List[String] = Nil
  }

  import collection.mutable

  def getDomain(url: String): String = url.split("/")(2)

  def crawl(startUrl: String, htmlParser: HtmlParser): Array[String] = {
    val domain = getDomain(startUrl)
    val ans = mutable.ArrayBuffer.empty[String]
    val queue = mutable.Queue(startUrl)
    val visited = mutable.Set(startUrl)

    while (queue.nonEmpty) {
      val url = queue.dequeue
      ans += url
      htmlParser.getUrls(url).foreach { next =>
        if (!visited(next) && getDomain(next) == domain) {
          visited += next
          queue.enqueue(next)
        }
      }
    }

    ans.toArray
  }
}