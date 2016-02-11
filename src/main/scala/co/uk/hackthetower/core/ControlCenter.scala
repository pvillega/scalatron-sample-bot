package co.uk.hackthetower.core

import cats.std.list._
import cats.data.{Xor, NonEmptyList}
import co.uk.hackthetower.commands.bot.{BotCommands, Log, Say}
import co.uk.hackthetower.commands.server.ServerCommand
import co.uk.hackthetower.exercises.{Ex2BotLogic, Ex1ValidateInput}

import scala.util.Random

/**
  * DO NOT EDIT
  * This class provides scaffolding to link the code implemented by users and the bot behaviour
  */
class ControlCenter {

  def processRequest(input: String): String =
    Ex1ValidateInput.parseInput(input)
      .fold(
        fe => logInvalidCommand(fe),
        fs => runStep(fs)
      ).mkString("|")

  protected def runStep(command: ServerCommand): List[BotCommands] =
    Ex2BotLogic.processServerCommand(wrapCommand(command))
      .fold(l => logInvalidCommand(List(l)), identity)

  //this method is useless, but we added it to enforce usage of Xor (educational purposes)
  protected def wrapCommand(command: ServerCommand) =
    if(Random.nextInt(100) < 1) Xor.left("NETWORK ERROR!") else Xor.right(command)

  protected def logInvalidCommand(errors: NonEmptyList[String]) = logInvalidCommand(errors.unwrap)

  protected def logInvalidCommand(errors: List[String]): List[BotCommands] =
    errors.flatMap(msg => List(Log(msg), Say(msg)))
}

