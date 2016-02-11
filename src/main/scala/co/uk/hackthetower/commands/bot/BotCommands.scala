package co.uk.hackthetower.commands.bot

/**
  * Represents a command issued by the Bot logic
  * See: https://github.com/hackthetower-london-scalatron/scalatron/blob/master/Scalatron/doc/markdown/Scalatron%20Protocol.md
  */
trait BotCommands {
  protected def stateToString(state: Map[String, String]) = state.map{ case (k,v) => s"$k=$v" }.mkString(",")
}
