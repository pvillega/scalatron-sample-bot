package co.uk.hackthetower.commands.bot

/**
  * Move(direction=int:int)
  *
  * Moves the bot one cell in a given direction, if possible. The delta values are signed integers. The permitted values are -1, 0 or 1.
  *
  * Parameters:
  *
  * direction: desired displacement for the move, e.g. 1:1 or 0:-1
  * Example:

  * Move(direction=-1:1) moves the entity left and down.
  * Energy Cost/Permissions:
  *
  * for master bot: 0 EU (free)
  * for mini-bot: 0 EU (free)
  */
case class Move(direction: (Int, Int)) extends BotCommands {
  override def toString: String = s"Move(direction=${direction._1}:${direction._2})"
}