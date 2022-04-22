package com.hackerrank.assignment.easy

import scala.collection.mutable.ListBuffer

object StringCompression {
  def main(args:Array[String]):Unit ={
    println(f("aaab"))
  }

  def f(str:String): String ={
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
