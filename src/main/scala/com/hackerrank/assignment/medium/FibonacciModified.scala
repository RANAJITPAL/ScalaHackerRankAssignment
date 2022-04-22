package com.hackerrank.assignment.medium

object FibonacciModified {
  def main(args: Array[String]): Unit = {
    var sc = scala.io.StdIn
    var t1 = sc.readInt()
    var t2 = sc.readInt()
    var n = sc.readInt()
    //    var result:Int = 0
    for (_ <- 0 until n - 2) {
      var temp = t2
      t2 = t1 + t2 * t2
      t1 = temp
    }
    println(t2)
  }
}
