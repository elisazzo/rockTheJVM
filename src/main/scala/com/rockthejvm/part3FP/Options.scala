package com.rockthejvm.part3FP

import scala.util.Random

object Options {

  // options = mini collections with at most, one value (single element collections)

  val anOption: Option[Int] = Option(42)
  val anEmptyOption: Option[Int] = Option.empty

  val aPresentVlaue: Option[Int] = Some(4)
  val anEmptyOption_v2: Option[Int] = None

  val isEmpty = anOption.isEmpty
  val innerValue = anOption.getOrElse(90)
  val anotherOption = Option(46)
  val aChainedOption = anEmptyOption.orElse(anotherOption)

  // map, flatMap, filter, for
  val anIncrementedOption = anOption.map(_ + 1) // Some(43)
  val aFilteredOption = anIncrementedOption.filter(_ % 2 == 0) // (None)
  val aFlatMappedOption = anOption.flatMap(value => Option(value * 10))

  // options allow us to work with unsafe API
  // options are used to handle the absence of a value (null - the null pointer reference can cause problems)

  def unsafeMethod(): String = null
  def fallbackMethod(): String = "some valid result"
  // defensive style
  val stringLength = {
    val potentialString = unsafeMethod()
    if (potentialString == null) -1
    else potentialString.length
  }

  // option-style
  val stringLengthOption = Option(unsafeMethod()).map(_.length) // .map(_.length) converts null into an Option[Int]


  // DESIGN
  def betterUnsafeMethod(): Option[String] = None
  def betterFallbackMethod(): Option[String] = Some("A valid result")
  val betterChain = betterUnsafeMethod().orElse(betterFallbackMethod())

  // example: Map.get
  val phoneBook = Map(
    "Daniel" -> 1234
  )
  val marysPhoneNumber = phoneBook.get("Mary")

  /* exercise */
  val config: Map[String, String] = Map(
    "host" -> "176.45.32.1",
    "port" -> "8081"
  )

  val configHost = config.get("host")
  val configPort = config.get("port")
  val connection = configHost.flatMap(h => configPort.flatMap(p => Connection(h, p)))
  val connStatus = connection.map(_.connect())

  class Connection {
    def connect(): String = "Connection successful"
  }

  object Connection{
    val random = new Random()

    def apply(host: String, port: String): Option[Connection] =
      if (random.nextBoolean()) Some(new Connection)
      else None
  }

  def main(args: Array[String]): Unit = {
  println(connStatus.getOrElse("failed to establish connection"))
  }

}
