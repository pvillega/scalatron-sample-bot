package co.uk.hackthetower.exercises

import cats.data.Validated.Invalid
import cats.data.{OneAnd, ValidatedNel}
import co.uk.hackthetower.commands.server.ServerCommand

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

  //TODO: START HERE
  /**
    * This method parses the input of the server and validates it to ensure we got a valid command
    *
    * @param input the input sent by the server. As per specification it will only have 1 command.
    * @return a ValidatedNel[String, ServerCommand], equivalent to Validated[NonEmptyList[String], ServerCommand]
    */
  def parseInput(input: String): ValidatedNel[String, ServerCommand] = Invalid(OneAnd("Missing implementation", List()))

}
