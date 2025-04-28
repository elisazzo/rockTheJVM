package com.rockthejvm.part2OOP

object Inheritence {

  class Animal {
    val creatureType = "wild"
    def eat(): Unit = println("nom, nom")
  }

  class Cat extends Animal {
    def crunch() = {
      eat()
      println("crunch, crunch")
    }
  }

  val cat = new Cat

  class Person(val name: String, age: Int){
    def this(name: String) = this(name, 0)
  }

  class Adult(name: String, age: Int, idCard: String) extends Person(name, age)  // must specify super-constructor in class declaration


  // subtype polymorphism
  val dog: Animal = new Dog
  dog.eat() // the most specific method will be called at run time

  // overloading vs overriding
  // overriding
  class Dog extends Animal {
    override val creatureType: String = "domestic"

    // override def eat(): Unit = super.eat() // refers to eat() in the super class Animal
    override def eat(): Unit = println("I like this bone")
    override def toString: String = "a dog"

    // overloading - multiple methods with the same name but different signatures
    // aka different arguments (number and type) and different return type (optional)
    def eat(animal: Animal): Unit = println("I am eating this man")
    def eat(dog: Dog): Unit = println("eating a dog")
    def eat(person: Person, dog: Dog): Unit = println("eating a person and a dog")
   // def eat(): Int = 45 // this will not compile! eat() is already defined on ln 36
  }


  def main(args: Array[String]): Unit = {
    cat.eat() // nom, nom
    cat.crunch() //nom, nom crunch, crunch

    dog.eat() // I like this bone NOT nomnom
    println(dog) // prints the toString method println(dog.toString) -> a dog
  }

}
