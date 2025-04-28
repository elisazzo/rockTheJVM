package com.rockthejvm.part3FP

object HOFsCurrying {

  // higher order functions (HOFs)
  val aHof: (Int, (Int => Int)) => Int = (x, func) => x + 1
  val anotherHof: Int => (Int => Int) = x => (y => y + 2 * x) // returns a function type

  // a function type: (left side is arg type (function) and right side is return type (int) ) (Int, (Int => Int)) => Int

  val superFunction: (Int, (String, (Int => Boolean)) => Int) => (Int => Int) = (x, func) => (y => x + y)

  // higher order functions take other functions as arguments rg msp, flatMap, failter

  // examples
  def nTimes(f : Int => Int, n: Int, x: Int): Int =
    if (n <= 0) x
    else nTimes(f, n-1, f(x))

  val plusOne = (x: Int) => x + 1
  val tenThousand = nTimes(plusOne, 10000, 0)

  def nTimes_v2(f: Int => Int, n: Int): Int => Int =
    if (n <= 0)(x: Int) => x
    else (x: Int) => nTimes_v2(f, n-1)(f(x))

  val plusOneHundred = nTimes_v2(plusOne, 100)

  val plusTenThousand = nTimes_v2(plusOne, 10000)

  // currying - HOFs returning function instances
  val superAdder: Int => Int => Int = (x: Int) => (y: Int) => x + y
  val add3: Int => Int = superAdder(3) // 3 + y
  val invokeSuperAdder = superAdder(3)(100) // 103

  // curried functions - methods with multiple arg lists
  def curriedFormatter(formatValue: String)(x: Double): String = formatValue.format(x)
  val standardFormat: (Double => String) = curriedFormatter("%4.2f") // (x: Double) => "%4.2f".format(x)
  val preciseFormat: (Double => String) = curriedFormatter("%10.8f") // (x: Double) => "%10.8f".format(x)

  def main(args: Array[String]): Unit = {
    println(standardFormat(Math.PI))
    println(preciseFormat(Math.PI))
  }

}
