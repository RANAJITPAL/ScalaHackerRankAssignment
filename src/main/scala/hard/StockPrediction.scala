package com.hackerrank.assignment.hard

import java.util.Scanner

object StockPrediction {
  def main(args:Array[String]):Unit ={
    var sc = new Scanner(System.in)
    var n:Int = sc.nextInt()
    var arr:Array[Int] = Array.fill(n)(sc.nextInt())
    var q:Int = sc.nextInt()
    for(i <- 0 until q){
      var d:Int = sc.nextInt()
      var M:Int = sc.nextInt()

      var num = arr(d)
      var left = d
      while(left >= 0 && num <= arr(left) && arr(left)<= num+M){
        left -= 1
      }

      var right = d
      while(right<n && num <= arr(right) && arr(right)<=num+M){
        right += 1
      }
      println(right-left-1)
    }

  }
}
