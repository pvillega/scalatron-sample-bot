package co.uk.hackthetower.exercises

import cats.data.Xor
import co.uk.hackthetower.commands.bot._
import co.uk.hackthetower.commands.server.ServerCommand

/**
  * Second exercise: Implement method 'processServerCommand'
  *
  * This method receives an Xor[String, ServerCommand] instance and will return an Xor answer.
  *
  * Input:
  * - we receive a Left of String if the input is invalid
  * - we receive a Right of ServerCommand if we got the right command
  *
  * Note that receiving a Left doesn't mean we can't still send BotCommands to the server with instructions.
  *
  * Output:
  * - if the processing fails, we will send a Left with an error message.
  * This will be automatically converted to Say and Log commands for the server.
  * - if the processing succeeds, we will send a Right with a list of BotCommands to send to the server
  *
  * Aims:
  * - Learn to work with Xor to propagate error states
  * - Learn to use both right/left sides as well as mapping over them
  *
  * See:
  * - http://typelevel.org/cats/tut/xor.html
  */
object Ex2BotLogic {

  def processServerCommand(command: Xor[String, ServerCommand]): Xor[String, List[BotCommands]] =
    Xor.right(List(
      DrawLine((2, 2), (4, 4), "#ff8800"),
      Explode(1),
      Log("log"),
      MarkCell((5, 5), "#ff8800"),
      Move((1, 1)),
      Say("HA HA!"),
      Set(Map("me" -> "you")),
      Spawn((3, 0), "minime", 1, Map("mini" -> "me")),
      Status("status)")
    ))
}
