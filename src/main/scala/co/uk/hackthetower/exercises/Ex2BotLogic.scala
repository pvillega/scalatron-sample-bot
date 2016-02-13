package co.uk.hackthetower.exercises

import cats.data.Xor
import co.uk.hackthetower.commands.bot._
import co.uk.hackthetower.commands.server.{React, ServerCommand}

import scala.util.Random

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
    command.bimap(identity, act)

  def act(s: ServerCommand): List[BotCommands] = s match {
    case React(generation, _,_,_,_,_,_,_,_) =>
      if(generation == 0) Move((direction, direction)) :: spawn
      else Move((direction, direction)) :: boom
    case _ => Say("Ignore command") :: Nil
  }

  def direction = Random.nextInt(3) - 1

  private def spawn = if(Random.nextInt(100) < 25) {
    Status("Go!") :: Spawn((direction,direction), "Son", 100, Map.empty) :: Nil
  } else Status("I'm winning!") :: Nil

  private def boom = if(Random.nextInt(100) < 5) {
    Status("Boom!") :: Explode(5) :: Nil
  } else Status("I'm hunting!") :: Nil
}
