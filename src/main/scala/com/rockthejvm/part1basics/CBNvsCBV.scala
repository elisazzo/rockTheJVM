package com.rockthejvm.part1basics

object CBNvsCBV {

  // CBV = arguments evaluated before function invocation
  def aFunction(arg: Int) = arg + 1

  //CBN = arguments are passed LITERALLY to the function
  // the argument is evaluated every time (anew) that it is used in the function vs only
  // once and that first value reused
  def aByNameFunction(arg: => Int) = arg + 1

  def main(args: Array[String]): Unit = {

  }
}
