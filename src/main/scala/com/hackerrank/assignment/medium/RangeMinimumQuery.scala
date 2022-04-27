package com.hackerrank.assignment.medium
import scala.collection.mutable.ListBuffer
import scala.io.StdIn.readLine


object RangeMinimumQuery {
  def main(args: Array[String]):Unit ={
//    var arr = List(10 ,20, 30, 40, 11, 22, 33, 44, 15, 5)
//    var query = List((0,5),(1,2),(8,9),(0,9),(4,6))
var input1 = readLine().split(" ")
    //var len = input1(0)
    var q = input1(1).toInt
    var arr = readLine().split(" ").map(x => x.toInt)
    var query = new ListBuffer[(Int,Int)]();
    for(i <- 0 until q ){
      var temp = readLine().split(" ").map(x => x.toInt)
      query.append((temp(0),temp(1)))
    }
    query.foreach{
      case (l,r) =>
        var min = Int.MaxValue
        for(i<- l to r){
          if (min>arr(i)) min = arr(i)
        }
        println(min)
    }
  }
}
