package com.rockthejvm.part2OOP

object Objects {

  object MySingleton { // type + the only instance of this type
    val aField = 45
    def aMethod(x: Int) = x + 1
  }

  val theSingleton = MySingleton
  val anotherSingleton = MySingleton
  val isSameSingleton = theSingleton == anotherSingleton

  // objects can have fields and methods
  val theSingletonField = MySingleton.aField
  val theSingletonMethodField = MySingleton.aMethod(99)

  class Person(name: String) { // instance dependent functionality
    def sayHi(): String = s"Hi, my name is $name"
  }
  // companions = class + object with the same name in the same file
  object Person { // companion object
    // can access each other's private fields and methods
    // do not depend on a specific instance of Person (instance independent functionality - "static")
    val N_EYES = 2
    def canFly(): Boolean = false
  }

  val mary = new Person("Mary")
  val mary_v2 = new Person("Mary")
  val marysGreeting = mary.sayHi()

  val humansCanFly = Person.canFly()
  val nEyesHuman = Person.N_EYES

  // equality
  // 1 equality of reference - usually defined as ==
  val sameMary = mary eq mary_v2 // false, different class instances
  val sameSingleton = MySingleton eq MySingleton // true
  // 2 equality of "sameness" - the programmer defines sameness
  // in Java, this is defined as .equals
  val sameMary_v2 = mary equals mary_v2 // false
  val sameMary_v3 = mary == mary_v2 // false, same as equals
  val sameSingleton_v2 = MySingleton == MySingleton // true

  // objects can extend classes
  object BigFoot extends Person("Big Foot")


  // Scala application = object + def main(args: Array[String]): Unit
  /* Java application =
        public class Objects {
        public static void main(String[] args) {...}
   */
  def main(args: Array[String]): Unit = {
    println(isSameSingleton) // true
    println(sameSingleton)
  }
}
