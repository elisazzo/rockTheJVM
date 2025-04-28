package com.rockthejvm.part2OOP

object AnonymousClasses {

  abstract class Animal {
    def eat(): Unit
  }

  class SomeAnimal extends Animal {
    override def eat():Unit = println("I'm a wierd animal")
  }

  val someAnimal = new SomeAnimal

  val someAnimal_v2 = new Animal { // anonymous class
    override def eat(): Unit = println("I'm a wierd animal")
  } // inline definition of SomeAnimal, useful if it is only going to be used once

  class Person(name:String) {
    def sayHi(): Unit = println(s"Hi, my name is $name")
  }

  val jim = new Person("Jim") {
    override def sayHi():Unit = println("MY NAME IS JIM")
  }



  def main(args: Array[String]): Unit = {

  }

}
