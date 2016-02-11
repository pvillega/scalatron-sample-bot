package co.uk.hackthetower.commands.bot

/**
  * DrawLine(from=int:int,to=int:int,color=string)
  *
  * Draws a line. You can use this as a debugging tool.
  *
  * Parameters:
  *
  * from starting cell of the line to draw, e.g. -2:4 (defaults to 0:0)
  * to destination cell of the line to draw, e.g. 3:-2 (defaults to 0:0)
  * color color to use for marking the cell, using HTML color notation, e.g. #ff8800 (default: #8888ff)
  * Energy Cost/Permissions:
  *
  * for master bot: permitted, no energy consumed
  * for mini-bot: permitted, no energy consumed
  *
  */
case class DrawLine(from: (Int, Int), to: (Int, Int), color: String) extends BotCommands {
  override def toString: String = s"DrawLine(from=${from._1}:${from._2},to=${to._1}:${to._2},color=$color)"
}
