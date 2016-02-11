package co.uk.hackthetower.commands.bot

/**
  * Log(text=string)
  *
  * Shortcut for setting the state property debug, which by convention contains an optional (multi-line) string with debug information related to the entity that issues this opcode. This text string can be displayed in the browser-based debug window to track what a bot or mini-bot is doing. The debug information is erased each time before the control function is called, so there is no need to set it to an empty string.
  *
  * Parameters:
  *
  * text the debug message to store. The usual restrictions for string values apply (no commas, parentheses, equals signs or pipe characters). Newline characters are permitted, however.
  * Energy Cost/Permissions:
  *
  * for master bot: permitted, no energy consumed
  * for mini-bot: permitted, no energy consumed
  *
  */
case class Log(text: String) extends BotCommands {
  override def toString: String = s"Log(text=$text)"
}
