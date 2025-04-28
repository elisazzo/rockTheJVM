package com.rockthejvm.part2OOP

val meaningOfLife = 42
def computeMyLife: String = "Scala"

object PackagesImports {

  // packages = "folders"

  // fully qualified name
  val aList: com.rockthejvm.practice.LList[Int] = ??? /// ??? throws NotImplementedError

  // import
  import com.rockthejvm.practice.LList
  val anotherList: LList[Int] = ???

  // import under an alias
  import java.util.List as JList
  val aJavaList: JList[Int] = ???

  // import everything
  import com.rockthejvm.practice.*

  // import multiple symbols
  import PhsyicsConstants.{SPEED_OF_LIGHT, EARTH_GRAVITY}
  val c = SPEED_OF_LIGHT

  // import everything but something
  object PlayingPhsyics{
    import PhsyicsConstants.{PLACK as _, *} // excludes PLACK from import
    // val plack = PLACK // will not work
  }

  import com.rockthejvm.part2OOP.* // imports meaningOfLife and computeMyLife as global variables
  val mol = meaningOfLife

  // default imports
  // scala.*, scalaPredef.*, java.lang.*

  // exports
  class PhysicsCalculator {
    import PhsyicsConstants.*
    def computePhotonEnergy(wavelength: Double): Double =
      PLACK / wavelength
  }

  object ScienceApp {
    val physicsCalculator = new PhysicsCalculator

    export physicsCalculator.computePhotonEnergy

    def computeEquivalentMass(wavelength: Double): Double =
      computePhotonEnergy(wavelength) / (SPEED_OF_LIGHT * SPEED_OF_LIGHT)
  }

  def main(args: Array[String]): Unit = {

  }

  object PhsyicsConstants {
    // constants
    val SPEED_OF_LIGHT = 299792458
    val PLACK = 6.62e-34 // scientific notation e
    val EARTH_GRAVITY = 9.8
  }

}
