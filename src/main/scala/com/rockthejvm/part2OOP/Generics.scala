package com.rockthejvm.part2OOP

object Generics {
  // reuse code on different types

  abstract class MyList[A] { // "generic" list
    def head: A
    def tail: MyList[A]
  }

  class Empty[A] extends MyList[A] {
    override def head: A = throw new NoSuchElementException
    override def tail: MyList[A] = throw new NoSuchElementException
  }

  class NonEmpty[A](override val head: A, override val tail: MyList[A]) extends MyList[A]

  val aListOfIntegers: MyList[Int] = new NonEmpty[Int](1, new NonEmpty[Int](2, new Empty[Int]))
  val aListOfStrings: MyList[String] = new NonEmpty[String]("Scala", new NonEmpty[String]("Java", new Empty[String]))

  val firstNumber = aListOfIntegers.head
  val adding = firstNumber + 3

  // multiple generic types
  trait MyMap[Key, Value]

  object MyList {
    def from2Elements[A](elem1: A, elem2: A): MyList[A] =
      new NonEmpty[A](elem1, new NonEmpty[A](elem2, new Empty[A]))
  }

  // calling methods
  val first2Numbers = MyList.from2Elements[Int](1, 2)
  val first2Numbers_v = MyList.from2Elements(1, 2)



  def main(args: Array[String]): Unit = {

  }

}
