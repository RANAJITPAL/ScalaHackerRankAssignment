package com.hackerrank.assignment.medium

import scala.math.pow
import scala.util.control.Breaks.{break, breakable}

object CaptainPrime {
  def main(args: Array[String]): Unit = {
    var list = List(43, 23, 66, 29) //3137, 1367, 2333, 101, 12
    // 43, 23, 66,29
    var isPrime = getPrimeNumbers(3167)
    for (i <- list) {
      println(getPosition(i, isPrime))
    }
  }

  //getting the persion's position
  def getPosition(num: Int, isPrime: Array[Boolean]): String = {
    var numLeft: Int = num
    var numRight: Int = num
    var isPositionRight: Boolean = true
    var isPositionLeft: Boolean = true
    if (num.toString.contains('0')) "DEAD"
    else {
      breakable {
        while (numRight > 0) {
          if (!isPrime(numRight)) {
            isPositionRight = false
            break
          }
          numRight = numRight / 10
        }
      }
      var mod: Int = pow(10, num.toString.length).toInt
      //      println("mod = " + mod)
      breakable {
        while (numLeft > 0) {
          if (!isPrime(numLeft)) {
            isPositionLeft = false
            break
          }
          numLeft = numLeft % mod
          mod /= 10
        }
      }

      if (isPositionRight && isPositionLeft) "CENTRAL"
      else if (isPositionRight) "RIGHT"
      else if (isPositionLeft) "LEFT"
      else "DEAD"
    }
  }


  //getting all the prime numbers
  def getPrimeNumbers(num: Int): Array[Boolean] = {
    var isPrime: Array[Boolean] = Array.fill(num + 1)(true)
    for (i <- 2 to num; if i * i <= num) {
      if (isPrime(i)) {
        var j = 2 * i
        while (j <= num) {
          isPrime(j) = false
          j += i
        }
      }
    }
    isPrime
  }
}
