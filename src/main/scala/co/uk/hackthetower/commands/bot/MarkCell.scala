package co.uk.hackthetower.commands.bot

/**
  * MarkCell(position=int:int,color=string)
  *
  * Displays a cell as marked. You can use this as a debugging tool.
  *
  * Parameters:
  *
  * position desired displacement relative to the current bot, e.g. -2:4 (defaults to 0:0)
  * color color to use for marking the cell, using HTML color notation, e.g. #ff8800 (default: #8888ff)
  * Energy Cost/Permissions:
  *
  * for master bot: permitted, no energy consumed
  * for mini-bot: permitted, no energy consumed
  */
case class MarkCell(position: (Int, Int), color: String) extends BotCommands {
  override def toString: String = s"MarkCell(position=${position._1}:${position._2},color=$color)"
}
