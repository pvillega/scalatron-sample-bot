package co.uk.hackthetower.commands.bot

/**
  * Explode(size=int)
  *
  * Detonates the mini-bot, dissipating its energy over some blast radius and damaging nearby entities. The mini-bot disappears. Parameters:
  *
  * size an integer value 2 < x < 10 indicating the desired blast radius
  * Energy Cost/Permissions:
  *
  * for master bot: cannot explode itself
  * for mini-bot: entire stored energy
  */
case class Explode(size: Int) extends BotCommands {
  override def toString: String = s"Explode(size=$size)"
}
