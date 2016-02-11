package co.uk.hackthetower.commands.bot

/**
  * Set(key=value,...)
  *
  * Sets one or more state parameters with the given names to the given values. The state parameters of the entity will be passed along to all subsequent control function invocations with React. This allows an entity to store state information on the server, making its implementation immutable and delegating state maintenance to the server.
  *
  * The usual restrictions for strings apply (no comma, parentheses, equals sign or pipe characters).
  * The following property names are reserved and must not be used for custom properties: generation, name, energy, time, view, direction, master, collision.
  * Properties whose values are empty strings are deleted from the state properties.
  * Energy Cost/Permissions:
  *
  * for master bot: permitted, no energy consumed
* for mini-bot: permitted, no energy consumed
  *
  */
case class Set(state: Map[String, String]) extends BotCommands {
  override def toString: String = s"Set(${stateToString(state)})"
}
