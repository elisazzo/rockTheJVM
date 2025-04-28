package com.rockthejvm.part1basics

import scala.annotation.tailrec

object DefaultArgs {
  
  @tailrec
  def sumUntilTailrec(x: Int, accumulator: Int): Int =
    if (x <= 0) accumulator
    else sumUntilTailrec(x - 1, accumulator + x)

  def main(args: Array[String]): Unit = {

  }
}
