package com.hackerrank.assignment.medium

object SuperDigit {
  def main(args: Array[String]): Unit = {
    //making the string of array to array on Int
    var n = 148.toString.toCharArray.map(char => char.toInt - '0')
    var k = 3
    var digits: IndexedSeq[Int] = for (_ <- 0 until k) yield f(n)
    println(f(digits.toArray))
  }

  //doing the som of all digit's of the array 
  //if the value is one digit the return else making a recursive call to the function
  def f(digits: Array[Int]): Int = {
    //    println(digits.mkString(" "))
    if (digits.length == 1) digits(0)
    else f(digits.sum.toString.toCharArray.map(char => char.toInt - '0'))
  }
}
