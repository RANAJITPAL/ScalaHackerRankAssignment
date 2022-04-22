package com.hackerrank.assignment.hard

import java.io.{BufferedReader, InputStreamReader}

object BangaloreBank {
  var n = 0
  var dp = Array.ofDim[Int](10005, 10, 10)
  var arr: Array[Int] = null

  def main(args: Array[String]) {
    val rd = new BufferedReader(new InputStreamReader(System.in))
    n = rd.readLine().toInt
    arr = rd.readLine().split(' ').map(_.toInt)
    if (n <= 2) {
      println(n)
      return
    }
    for (i <- 0 until n; j <- 0 until 10; k <- 0 until 10) {
      dp(i)(j)(k) = -1;
    }
    var ans = solve(2, arr(0), arr(1))
    for (i <- 0 until 10) {
      ans = math.min(ans, solve(1, arr(0), i))
    }
    println(ans + n)
  }

  def getDistance(a: Int, b: Int): Int = {
    var aa = if (a == 0) 10 else a
    var bb = if (b == 0) 10 else b
    math.abs(aa - bb)
  }

  def solve(k: Int, x: Int, y: Int): Int = {
    if (k == n) return 0
    if (dp(k)(x)(y) != -1) return dp(k)(x)(y);
    dp(k)(x)(y) = math.min(solve(k + 1, arr(k), y) + getDistance(x, arr(k)), solve(k + 1, x, arr(k)) + getDistance(y, arr(k)))
    dp(k)(x)(y)
  }
}
