package com.hackerrank.assignment.medium

import scala.io.StdIn.readLine
import scala.annotation.tailrec

object SuperDigit {
 def main(args:Array[String]):Unit ={
   var input = readLine().split(" ")
    var n = input(0).toString.toCharArray.map(char => char.toInt-'0')
    var k = input(1).toInt
    var digits:IndexedSeq[Int] = for(_ <- 0 until k) yield f(n)
    println(f(digits.toArray))
  }

    @tailrec 
  def f(digits:Array[Int]):Int ={
//    println(digits.mkString(" "))
    if(digits.length == 1) digits(0)
    else f(digits.sum.toString.toCharArray.map(char => char.toInt -'0'))
  }
}
