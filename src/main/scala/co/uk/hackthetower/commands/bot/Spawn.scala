package co.uk.hackthetower.commands.bot

/**
  * Spawn(direction=int:int,name=string,energy=int,...)
  *
  * Spawns a mini-bot from the position of the current entity at the given cell position, expressed relative to the current position.
  *
  * Parameters:
  *
  * direction: desired displacement for the spawned mini-bot, e.g. -1:1
  * name: arbitrary string, except the following characters are not permitted: |, ,, =, (
  * energy: energy budget to transfer to the spawned mini-bot (minimum: 100 EU)
  *
  * Defaults:
  *
  * name = Slave_nn an auto-generated unique slave name
  * energy = 100 the minimum permissible energy
  * Additional Parameters:
  *
  * In addition to the parameters listed above, the command can contain arbitrary additional parameter key/value pairs. These will be set as the initial state parameters of the entity and will be passed along to all subsequent control function invocations with React. This allows a master bot to "program" a mini-bot with arbitrary starting parameters.
  * The usual restrictions for strings apply (no comma, parentheses, equals sign or pipe characters).
  * The following property names are reserved and must not be used for custom properties: generation, name, energy, time, view, direction, master, collision.
  * Properties whose values are empty strings are ignored.
  * Example:
  *
  * Spawn(direction=-1:1,energy=100) spawns a new mini-bot one cell to the left and one cell down, with an initial energy of 100 EU.
  * Energy Cost/Permissions:
  *
  * for master bot: as allocated via energy
  * for mini-bot: as allocated via energy
  * Note that this means that mini-bots can spawn other mini-bots (if they have the required energy, i.e. at least 100 EU).
  */
case class Spawn(direction: (Int, Int), name: String, energy: Int, state: Map[String, String]) extends BotCommands {
  override def toString: String = s"Spawn(direction=${direction._1}:${direction._2},name=$name,energy=$energy,${stateToString(state)})"
}
