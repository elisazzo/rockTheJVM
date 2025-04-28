package com.rockthejvm.practice

import java.util.function.Predicate
import scala.annotation.{tailrec, targetName}

abstract class LList[A] {
  def head: A
  def tail: LList[A]
  def isEmpty: Boolean
  def add(element: A): LList[A] = new Cons(element, this)
  
  // concatenation function
  infix def ++(anotherList: LList[A]): LList[A]

  def map[B](transformer: A => B): LList[B]
  def filter(predicate: A => Boolean): LList[A]
  def flatMap[B](transformer: A => LList[B]): LList[B]

}

case class Empty[A]() extends LList[A] {
  override def head: A = throw new NoSuchElementException()
  override def tail: LList[A] = throw new NoSuchElementException()
  override def isEmpty = true
  override def toString: String = "[]"

  override infix def ++(anotherList: LList[A]): LList[A] = anotherList
  override def map[B](transformer: A => B): LList[B] = Empty()
  override def filter(predicate: A => Boolean): LList[A] = this
  override def flatMap[B](transformer: A => LList[B]): LList[B] = Empty()



}

case class Cons[A](override val head: A, override val tail: LList[A]) extends LList[A] {
  override def isEmpty: Boolean = false

  override def toString: String = {
    @tailrec
    def concatenateElements(remainder: LList[A], acc: String): String =
      if (remainder.isEmpty) acc
      else concatenateElements(remainder.tail, s"$acc, ${remainder.head}")

    s"[${concatenateElements(this.tail, s"$head")}]"
  }

  /*
  map example
  [1, 2, 3].map(n * 2) =
  new Cons(2, [2,3].map(n * 2)) =
  new Cons(2, new Cons(4, [3].map(n * 2)) =
  new Cons(2, new Cons(4, new Cons(6, [].map(n * 2)) =
  new Cons(2, new Cons(4, new Cons(6, []))) =
  [2, 4, 6]
   */
  override def map[B](transformer: A => B): LList[B] = Cons(transformer(head), tail.map(transformer))
  
  /*
  filter example
  [1, 2, 3].filter(n % 2 == 0) = 
  [2, 3].filter(n % 2 == 0) =
  new Cons(2, [3].filter(n % 2 == 0)) =
  new Cons(2, [].filter(n % 2 == 0)) =
  new Cons(2, []) =
  [2]
  
   */
  override def filter(predicate: A => Boolean): LList[A] =
    if (predicate(head)) new Cons(head, tail.filter(predicate))
    else tail.filter(predicate)

  override infix def++(anotherList:LList[A]): LList[A] = Cons(head, tail ++ anotherList)

  override def flatMap[B](transformer: A => LList[B]): LList[B] = transformer(head) ++ tail.flatMap(transformer)


}

// replaced with function types

//trait Predicate[T] {
//  def test(element: T): Boolean
//}
//
//class EvenPredicate extends Predicate[Int] {
//  override def test(element: Int): Boolean =
//    element % 2 == 0
//}
//
//trait Transformer[A, B] {
//  def transform(value: A): B
//}
//
//class DoubleTransform extends Transformer[Int, Int] {
//  override def transform(value: Int): Int =
//    value * 2
//
//}
//
//class DoubleListTransform extends Transformer[Int, LList[Int]] {
//  override def transform(value: Int): LList[Int] =
//    Cons(value, Cons(value + 1, new Empty))
//}

object LList {
  @tailrec
  def find[A](list: LList[A], predicate: Predicate[A]): A =
    if (list.isEmpty) throw new NoSuchElementException
    else if (predicate.test(list.head)) list.head
    else find(list.tail, predicate)
}

object LListTest {
  def main(args: Array[String]): Unit = {
    val empty = new Empty[Int]
    println(empty.isEmpty) // false

    val first3Numbers = Cons(1, Cons(2, Cons(3, empty)))
    println(first3Numbers)
    val first3Numbers_v2 = empty.add(1).add(2).add(3)
    println(first3Numbers_v2.isEmpty)

    val someStrings =  Cons("dog",  Cons("cat",  Cons("fish", new Empty)))
    println(someStrings) // [dog, cat, fish]

//    val evenPredicate = new Function1[Int, Boolean] {
//      override def apply(element: Int): Boolean = element % 2 == 0
//    }
      val evenPredicate: Int => Boolean = (element: Int) => element % 2 == 0


//    val doubler = new Function1[Int, Int] {
//      override def apply(value: Int): Int = value * 2
//    }
      val doubler: Int => Int = (value: Int) => value * 2


//    val doublerList = new Function[Int, LList[Int]] {
//      override def apply(value: Int) =
//        Cons(value, Cons(value + 1, new Empty))
//    }
      val doublerList: Int => LList[Int] = (value: Int) => Cons(value, Cons(value + 1, new Empty))

    // map testing
    val numbersDoubled = first3Numbers.map(doubler)
    val numbersDoubled_v2 = first3Numbers.map(x => x * 2)
    val numbersDoubled_v3 = first3Numbers.map(_ * 2)
    println(numbersDoubled) // [2, 4, 6]

    val nestedNumbers = first3Numbers.map(doublerList)
    val nestedNumbers_v2 = first3Numbers.map(x => Cons(x, Cons(x + 1, new Empty)))
    println(nestedNumbers) // [[1, 2], [2, 3], [3,4]]

    // filter testing
    val onlyEvenNumbers = first3Numbers.filter(evenPredicate)
    val onlyEvenNumbers_v2 = first3Numbers.filter(element => element % 2 == 0)
    println(onlyEvenNumbers) // [2]

    // test flatMap
    val flattenedList = first3Numbers.flatMap(doublerList)
    val flattenedList_v2  = first3Numbers.flatMap(x => Cons(x, Cons(x + 1, new Empty)))

    // find test
    println(LList.find[Int](first3Numbers , _ % 2 == 0  ))
    //   println(LList.find[Int](first3Numbers , new Predicate[Int] {
    //     override def test(element: Int) = element > 5
    //   })) // throws a NSEException

  }



}
