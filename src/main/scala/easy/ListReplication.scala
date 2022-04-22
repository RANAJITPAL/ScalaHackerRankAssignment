package com.hackerrank.assignment.easy

object ListReplication {
  def main(args: Array[String]): Unit = {
    println(f(3, Array(1, 2, 3, 4, 5)).mkString(","))
  }

  def f(num: Int, arr: Array[Int]): List[Int] = {
    arr.flatMap(List.fill(num)(_)).toList
  }
}
