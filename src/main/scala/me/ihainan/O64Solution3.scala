package me.ihainan

object O64Solution3 {
  def sumNums(n: Int): Int = {
    var current = n
    var sum = 0

    def oneInPos(i: Int): Boolean = {
      val mask = 1 << i
      (mask & (n + 1)) != 0
    }

    oneInPos(0) && {
      sum += current;
      sum >= 0
    }
    current <<= 1
    oneInPos(1) && {
      sum += current;
      sum >= 0
    }
    current <<= 1
    oneInPos(2) && {
      sum += current;
      sum >= 0
    }
    current <<= 1
    oneInPos(3) && {
      sum += current;
      sum >= 0
    }
    current <<= 1
    oneInPos(4) && {
      sum += current;
      sum >= 0
    }
    current <<= 1
    oneInPos(5) && {
      sum += current;
      sum >= 0
    }
    current <<= 1
    oneInPos(6) && {
      sum += current;
      sum >= 0
    }
    current <<= 1
    oneInPos(7) && {
      sum += current;
      sum >= 0
    }
    current <<= 1
    oneInPos(8) && {
      sum += current;
      sum >= 0
    }
    current <<= 1
    oneInPos(9) && {
      sum += current;
      sum >= 0
    }
    current <<= 1
    oneInPos(10) && {
      sum += current;
      sum >= 0
    }
    current <<= 1
    oneInPos(11) && {
      sum += current;
      sum >= 0
    }
    current <<= 1
    oneInPos(12) && {
      sum += current;
      sum >= 0
    }
    current <<= 1
    oneInPos(13) && {
      sum += current;
      sum >= 0
    }
    current <<= 1
    oneInPos(14) && {
      sum += current;
      sum >= 0
    }
    current <<= 1
    sum >> 1
  }
}