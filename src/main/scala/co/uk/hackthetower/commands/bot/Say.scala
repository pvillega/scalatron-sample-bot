package co.uk.hackthetower.commands.bot

/**
  * Say(text=string)
  *
  * Displays a little text bubble that remains at the position where it was created. Use this to drop textual breadcrumbs associated with events. You can also use this as a debugging tool. Don't go overboard with this, it'll eventually slow down the gameplay.
  *
  * Parameters:
  *
  * text the message to display; maximum length: 10 chars; can be an arbitrary string, except the following characters are not permitted: |, ,, =, (
  * Energy Cost/Permissions:
  *
  * for master bot: permitted, no energy consumed
  * for mini-bot: permitted, no energy consumed
  *
  */
case class Say(text: String) extends BotCommands {
  override def toString: String = s"Say(text=$text)"
}
