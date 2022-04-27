package com.hackerrank.assignment.hard

import scala.io.StdIn.readInt
import scala.io.StdIn.readLine
import scala.collection.mutable.ListBuffer


object ReverseFactorization {
  def main(args: Array[String]): Unit = {
    var input = readLine().split(" ")
    var num: Int = input(0).toInt
    var n: Int = input(1).toInt
    var arr: Array[Int] = readLine().split(" ").map(x => x.toInt)

   var dp: Array[Int] = Array.fill(num + 1)(Int.MaxValue)
    var result: Array[Int] = new Array[Int](num + 1)

    dp(1) = 0

    for (i <- 2 to num) {
      var min: Int = Int.MaxValue
      var prev: Int = Int.MaxValue
      for (x <- arr) {
        if (i % x == 0) {
          if (dp(i / x) <= min) {
            min = dp(i / x)
            if(prev > i / x){
              prev = i / x
            }
          }
        }
      }
      result(i) = prev
      if(min != Int.MaxValue)
      dp(i) = min+1
    }

//    println(dp.mkString(" "))
//    println(result.mkString(" "))

    if(dp(num) == Int.MaxValue) println(-1)
    else {
      val r = new ListBuffer[Int]
      do{
//        print(num+" ")
        r += num
        num = result(num)
      }while(num>=1)
      println(r.reverse.mkString(" "))
    }
    
  }
}
