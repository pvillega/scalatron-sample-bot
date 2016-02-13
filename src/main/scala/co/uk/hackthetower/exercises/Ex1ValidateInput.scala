package co.uk.hackthetower.exercises

import cats.data.Validated.{Invalid, Valid}
import cats.data.ValidatedNel
import cats.data.NonEmptyList
import co.uk.hackthetower.commands.server.{Goodbye, React, ServerCommand, Welcome}

/**
  * First exercise: Implement method 'parseInput'.
  *
  * This method must validate the input received from the server and return an object indicating
  * if the input was correct or not.
  * As per specification the input, if valid, will contain a single command, and will match one of the
  * 'ServerCommands' defined in the codebase. Incorrect scenarios may include invalid commands,
  * multiple commands, etc.
  *
  * Aims:
  * - Learn to work with Validated and OneAnd instances (NonEmptyList in this case)
  * - Understand the differences between Validated and Xor
  * - Understand the differences between OneAnd and NonEmptyList
  *
  * See:
  * - http://typelevel.org/cats/tut/validated.html
  * - http://typelevel.org/cats/tut/oneand.html
  */
object Ex1ValidateInput {

  val Wcm = """Welcome\(name=(\w+),apocalypse=([-\d]+),round=([-\d]+),maxslaves=([-\d]+)\)""".r
  val Gbye = """Goodbye\(energy=([-\d]+)\)""".r
  val Rct = """React\(generation=([-\d]+),name=(\w+),time=([-\d]+),view=(\w+),energy=(\w+),master=([-\d]+):([-\d]+),collision=([-\d]+):([-\d]+),slaves=([-\d]+)(.+)\)""".r
  val Pair = """(\w+)=(\w+)""".r
  /**
    * This method parses the input of the server and validates it to ensure we got a valid command
    *
    * @param input the input sent by the server. As per specification it will only have 1 command.
    * @return a ValidatedNel[String, ServerCommand], equivalent to Validated[NonEmptyList[String], ServerCommand]
    */
  def parseInput(input: String): ValidatedNel[String, ServerCommand] = input match {
    case Wcm(name, apocalypse, round, maxslaves) => Valid(Welcome(name, apocalypse.toInt, round.toInt, maxslaves.toInt))
    case Gbye(energy) => Valid(Goodbye(energy.toInt))
    case Rct(generation, name, time, view, energy, master1, master2, col1, col2, slaves, other) => Valid(React(generation.toInt, name, time.toInt, view, energy, (master1.toInt, master2.toInt), (col1.toInt, col2.toInt), slaves.toInt, parseOther(other)))
    case _ => Invalid(NonEmptyList("Not a valid server command"))
  }

  protected def parseOther(other: String): Map[String, String] =
    other.split(",").filterNot(_.isEmpty).map{ case Pair(k,v) => k -> v }.toMap
}
