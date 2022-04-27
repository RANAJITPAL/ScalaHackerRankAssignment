package com.hackerrank.assignment.easy

import scala.collection.mutable.ListBuffer
import scala.io.StdIn.readLine

object StringCompression {
  def main(args:Array[String]):Unit ={
//    println(f("aaabbbcc")) //a3b3c2
    var input = readLine();
    println(f(input))
  }

  def f(str:String): String ={
  if(str.length == 1) return str
    var count:Int = 1
    var lastChar:Char = str.charAt(0)
    var result:ListBuffer[String] = ListBuffer()
    for(i <- 1 until str.length-1){
      if(str.charAt(i) != lastChar){
        if(count == 1){
          result += lastChar.toString
          lastChar = str.charAt(i)
          count = 1
        }else{
          result += lastChar.toString + count.toString
          lastChar = str.charAt(i);
          count = 1
        }
      }else{
        count += 1
      }
    }
    if(str.charAt(str.length-1) != lastChar){
      if(count == 1){
        result += lastChar.toString+str.charAt(str.length-1).toString
      }else{
        result += lastChar.toString + count.toString + str.charAt(str.length-1).toString
      }
    }else{
      result += lastChar.toString+(count+1).toString
    }
    result.mkString("")
  }
}

