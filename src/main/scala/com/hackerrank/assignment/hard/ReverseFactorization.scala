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
    arr = arr.sorted.reverse;
    println(fun(arr,num))
  }
  
  def fun(arr:Array[Int],num:Int):String={
    var target: Int = num
    var result: List[Int] = List(num)
    var index: Int = 0
    while (index <= arr.length - 1 && target > 1)
    {
      if (target % arr(index) == 0) {
        target = target / arr(index)
        result = target :: result
      }
      else
      {
        index = index + 1
      }

    }
    if (target == 1)
      result.mkString(" ")
    else
      "-1"
  }
}
