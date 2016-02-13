package co.uk.hackthetower.commands.server

import cats._
import cats.data._
import cats.std.all._

/**
  * Welcome(name=String,apocalypse=int,round=int,maxslaves=int)
  *
  * "Welcome" is the first command sent by the server to a plug-in before any other invocations of the control function.
  *
  * Parameters:
  *
  * name: the player name associated with the plug-in. The player name is set based on the name of the directory containing the plug-in.
  * apocalypse: the number of steps that will be performed in the upcoming game round. This allows bots to plan ahead and to e.g. schedule the recall of harvesting drones. Keep in mind, however, that the control function of master bots is only invoked with React every second simulation step! See the Game Rules for details.
  * round: the index of the round for which the control function was instantiated. A game server continually runs rounds of the game, and the round index is incremented each time.
  * maxslaves: the number of slave bots that a user can have alive at any one time. If a call to Spawn is made when this number of user bots exist, then the request will be denied.
  *
  */
case class Welcome(name: String, apocalypse: Int, round: Int, maxslaves: Int) extends ServerCommand

object Welcome {

  private val Name = "name"
  private val Apocalypse = "apocalypse"
  private val Round = "round"
  private val MaxSlaves = "maxslaves"

  val allKeys = Name :: Apocalypse :: Round :: MaxSlaves :: Nil

  def fromMap(input: Map[String, String]): ValidatedNel[String, ServerCommand] =
    Apply[ValidatedNel[String, ?]].map4(
      ServerCommand.isPresent(input, Name),
      ServerCommand.isNumeric(input, Apocalypse),
      ServerCommand.isNumeric(input, Round),
      ServerCommand.isNumeric(input, MaxSlaves)
    ) {
      case (name, apocalypse, round, maxSlaves) =>
        Welcome(name, apocalypse, round, maxSlaves)
    }

}
