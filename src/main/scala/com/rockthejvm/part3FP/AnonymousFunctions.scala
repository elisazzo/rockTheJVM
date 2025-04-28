package com.rockthejvm.part3FP

object AnonymousFunctions {

  // instance of FunctionN
  val doubler: Int => Int = new Function1[Int, Int] {
    override def apply(x: Int) = x * 2
  }
  // shorthand
  // lambdas = anonymous function instances
  val doubler_v2: Int => Int = (x: Int) => x * 2 // identical to doubler
  val adder: (Int, Int) => Int = (x: Int, y: Int) => x + y // new Function2 [Int, Int, Int] {override def apply()...}

  // zero-arg functions
  val justDoSomething: () => Int = () => 45
  val anInvocation = justDoSomething()

  // alternative syntax with curly braces
  val stringToInt = { (str: String) =>
    // implementation
    str.toInt
  }

  // type inference
  val doubler_v3: Int => Int = x => x * 2 // infers x is of type Int
  val adder_v2: (Int, Int) => Int = (x,y) => x + y

  // shortest lambdas
  val doubler_v4: Int => Int = _ * 2 // x => x * 2 ("_" refers to the first arg of the function)
  val adder_v3: (Int, Int) => Int = _ + _ // each underscore refers to a *different* arg


  def main(args: Array[String]): Unit = {
    println(justDoSomething)
    println(justDoSomething())

  }


}
