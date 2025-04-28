package com.rockthejvm.part2OOP

object AbstractDataTypes {

  abstract class Animal {
    val creatureType: String // abstract
    def eat(): Unit
    // non-abstract fields/ methods are allowed
    val preferredMeal: String = "anything" // accessor methods

  }
//  val anAnimal: Animal = new Animal - Animal is abstract so cannot be instantiated

  class Dog extends Animal { // requires ALL Animal fields because Animal is an abstract class
    override val creatureType: String = "domestic"
    override def eat(): Unit = println("crunching this bone")

  // overriding is legal for everything
  override val preferredMeal: String = "bones" // overriding accessor method (without args/ parentheses) with a field
  }
  val aDog: Animal = new Dog

  // traits
  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  // abstract class vs trait
  // one class inheritance
  // multiple traits inheritance
  trait ColdBlooded
  class Crocodile extends Animal with Carnivore with ColdBlooded {
    override val creatureType: String = "croc"

    override def eat(): Unit = println("I'm a croc and love to eat")

    override def eat(animal: Animal): Unit = println{"croc eating animal"}
  }

  class TRex extends Carnivore {
    override def eat(animal: Animal): Unit = "I'm a TRex, I eat animals"
  }

  def main(args: Array[String]): Unit = {
  val croc = new Crocodile
  println(croc.eat())
  }
}
