package com.hackerrank.assignment.medium

object RangeMinimumQuery {
  def main(args: Array[String]): Unit = {
    var arr = List(10, 20, 30, 40, 11, 22, 33, 44, 15, 5)
    var query = List((0, 5), (1, 2), (8, 9), (0, 9), (4, 6))
    
    //Traversing through all the queries
    query.foreach {
      case (l, r) =>
        var min = Int.MaxValue
      //getting the minimum valu between th erange 
        for (i <- l to r) {
          if (min > arr(i)) min = arr(i)
        }
        println("min on range " + l + " to " + r + " =" + min)
    }
  }
}
