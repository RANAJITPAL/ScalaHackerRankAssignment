package com.hackerrank.assignment.easy

object ReverseAList {
  def main(args: Array[String]): Unit = {
    println(f(List(1, 2, 3, 4, 5)))
  }

  def f(arr: List[Int]): List[Int] = {
    val a = for (i <- arr.size - 1 to 0 by -1) yield arr(i)
    a.toList
  }
}
