package com.hackerrank.assignment.medium

import scala.math.pow
import scala.util.control.Breaks._
import scala.io.StdIn.readInt
import scala.collection.mutable.ListBuffer

object CaptainPrime {
def main(args: Array[String]): Unit = {
    var T = readInt()
    var list = new ListBuffer[Int]()
    for(i <- 0 until T){
        val id = readInt()
        list.append(id)
    }
    var isPrime = getPrimeNumbers(list.max)
    for(i<-list){
      println(getPosition(i,isPrime))
    }
  }

  def getPosition(num: Int, isPrime: Array[Boolean]): String = {
    var numLeft: Int = num
    var numRight: Int = num
    var isPositionRight: Boolean = true
    var isPositionLeft: Boolean = true
    if(num.toString.contains('0')) "DEAD"
    else {
      breakable {
        while (numRight > 0) {
          if (!isPrime(numRight) || numRight == 1) {
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
          if (!isPrime(numLeft) || numLeft == 1) {
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


  def getPrimeNumbers(num: Int): Array[Boolean] = {
    var isPrime: Array[Boolean] = Array.fill(num + 1)(true)
    isPrime(1) = false
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
