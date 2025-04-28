package com.rockthejvm.part3FP

object WhatsAFunction {

  // fp: functions are "first-class" citizens
  /// JVM

  trait MyFunction[A, B] {
    def apply(arg: A): B
  }

  val doubler = new MyFunction[Int, Int] {
    override def apply(arg: Int) = arg * 2
  }

  val meaningOfLife = 42
  val meaningDoubled = doubler(meaningOfLife)

  // function types
  val doublerStandard = new Function1[Int, Int] {
    override def apply(arg: Int) = arg * 2

  }
  val meaningDoubled_v2 = doublerStandard(meaningOfLife)

  val adder = new Function2[Int, Int, Int] {
    override def apply(a: Int, b: Int): Int = a + b
  }
  val anAddition = adder(2, 67)

  // all functions are instances of FunctionX with apply methods

  /* Exercise 1 */
  val concatenator: (String, String) => String = new Function2[String, String, String] {
    override def apply(string1: String, string2: String) = string1 + string2
  }

//  /* Exercise 3 */
//  trait exFunction[A, anotherFunction] {
//    def apply(arg: Int): anotherFunction
//  }
//
  val superAdder = new Function1[Int, Function1[Int, Int]] {
    override def apply(x: Int) = new Function1[Int, Int] {
      override def apply(y: Int) = x + y
    }
  }

// using a lambda
  val superAdder_v2 = (x:Int) => (y: Int) => x + y
  
val adder2 = superAdder(2)
val anAddition_v2 = adder2(67)
//currying
val anAddition_v3 = superAdder(2)(67)

// function values != methods
// defs are methods of classes/ traits
// function values are instances of function 1/2/ etc


  def main(args: Array[String]): Unit = {
    println(concatenator("I love", " scala"))
    println(anAddition_v2)
  }
}
