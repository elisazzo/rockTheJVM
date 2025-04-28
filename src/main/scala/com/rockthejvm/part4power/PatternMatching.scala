package com.rockthejvm.part4power

import scala.util.Random

object PatternMatching {

  // switch on steroids
  val random = new Random()
  val aValue = random.nextInt(100)

  val description = aValue match {
    case 1 => "the first"
    case 2 => "the second"
    case 3 => "the third"
    case _ => s"something else: $aValue"
  }

  // decompose values
  case class Person(name: String, age: Int) // case classes are automatically eligible for pattern matching
  val bob = Person("Bob", 20)

  val greeting = bob match {
    case Person(n, a) => s"Hello there, my name is $n and I'm not allowed to say my age."
    case _ => "I don't know who I am "
  }

  // Patterns are matched in order: put the most specific patterns first
  // What if no cases match? MatchError
  // What type is returned? The lowest common ancestor of all types on the RHS of each branch

  // PM on sealed hierarchies
  sealed class Animal
  case class Dog(breed: String) extends Animal
  case class Cat(meowStyle: String) extends Animal

  val anAnimal: Animal = Dog("Terra Nova")
  val animalPM = anAnimal match {
  case Dog(someBreed) => "detected dog"
  case Cat(meow) => "detected cat"
  }

  /* Exercise */
  sealed trait Expr
  case class Number(n: Int) extends Expr
  case class Sum(e1: Expr, e2: Expr) extends Expr
  case class Prod(e1: Expr, e2: Expr) extends Expr

  def show(expr: Expr): String = expr match {
    case Number(n) => s"$n"
    case Sum(left, right) => show(left) + " + " + show(right)
    case Prod(left, right) => {
      def maybeShowParentheses(exp: Expr) = exp match {
        case Prod(_, _) => show(exp)
        case Number(_) => show(exp)
        case Sum(_, _) => s"(${show(exp)})"
      }

      maybeShowParentheses(left) + " * " + show(right)
    }


  }


  def main(args: Array[String]): Unit = {
    println(description)

    println(show(Sum(Number(2), Number(3))))
    println(show(Sum(Sum(Number(2), Number(3)), Number(4))))
    println(show(Prod(Sum(Number(2), Number(3)), Number(4))))
  }

}
