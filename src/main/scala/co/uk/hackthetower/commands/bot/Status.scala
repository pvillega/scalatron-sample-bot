package co.uk.hackthetower.commands.bot

/**
  * Status(text=string)
  *
  * Shortcut for setting the state property 'status', which displays a little text bubble near the entity which moves around with the entity. Use this to tell spectators about what your bot thinks. You can also use this as a debugging tool. If you return the opcode Status, do not also set the status property via Set, since no particular order of execution is guaranteed.
  *
  * Parameters:
  *
  * text the message to display; maximum length: 20 chars; can be an arbitrary string, except the following characters are not permitted: |, ,, =, (
  * Energy Cost/Permissions:
  *
  * for master bot: permitted, no energy consumed
  * for mini-bot: permitted, no energy consumed
  */
case class Status(text: String) extends BotCommands {
  override def toString: String = s"Status(text=$text)"
}