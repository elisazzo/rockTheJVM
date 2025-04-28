package com.rockthejvm.part1basics

import scala.annotation.tailrec
import scala.jdk.Accumulator

object Recursion {

  // stack recursive
  def sumUntil(n: Int): Int =
    if (n<= 0) 0
    else n + sumUntil(n-1)

    // tail recursive
  def sumUntil_v2(n:Int): Int = {

    def sumUntilTailrec(x: Int, accumulator: Int): Int =
      if (x <= 0) accumulator
      else sumUntilTailrec(x - 1, accumulator + x)

    sumUntilTailrec(n, 0)
  }

  def sumNumbersBetween(a: Int, b: Int): Int = {
    if (a>b) 0
    else a + sumNumbersBetween(a + 1, b)
  }

//   def sumNumbersBetween_v2(a: Int, b: Int): Int =
//    @tailrec
//    def sumTailrec(currentNumber: Int, accumulator: Int): Int = {
//      if (currentNumber > b) accumulator
//      else sumTailrec(currentNumber + 1, currentNumber + accumulator)
//
//      sumTailrec(a, 0)
//    }

def concatenateString(string: String, n: Int): String = {
  if (n <= 0) " "
  else string + concatenateString(string, n-1)
}

//def concatenateString_v2(string: String, n: Int): String = {
//  @tailrec
//  def concatTailrec(remainder: Int, accumulator: String): String = {
//    if (remainder <= 0) accumulator
//    else concatTailrec(remainder - 1, string + accumulator)
//    concatTailrec(n, "")
//  }
//}


  def aFibonacciFunction(n: Int): Int = {
    if (n <= 2) 1
    else aFibonacciFunction((n-1) + aFibonacciFunction(n-2))
  }

//  def aFibonacciFunction_v2(n: Int): Int = {
//
//    def fibonacciTail(x: Int, accumulator: Int): Int = {
//      if (x <= 2) accumulator
//      else fibonacciTail((x + 1),(x + accumulator))
//
//      fibonacciTail(x, 0)
//    }
//
//  }

  def main(args: Array[String]): Unit = {
    println(concatenateString("scala", 5))
  }

}
