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
    var required_num: Int = num
    var output_list: List[Int] = List(num)
    var index: Int = 0
    while (index <= arr.length - 1 && required_num > 1)
    {
      if (required_num % arr(index) == 0) {
        required_num = required_num / arr(index)
        output_list = required_num :: output_list
      }
      else
      {
        index = index + 1
      }

    }
    if (required_num == 1)
      output_list.mkString(" ")
    else
      "-1"
  }
}
