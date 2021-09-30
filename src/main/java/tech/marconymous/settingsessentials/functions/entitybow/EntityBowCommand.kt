package tech.marconymous.settingsessentials.functions.entitybow

import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.entity.EntityType
import org.bukkit.entity.Player
import tech.marconymous.settingsessentials.SettingsEssentials
import tech.marconymous.settingsessentials.interfaces.CommandExecutor
import tech.marconymous.settingsessentials.string.purple
import java.util.*

class EntityBowCommand(config: SettingsEssentials) : CommandExecutor(config) {
    override val command: String
        get() = "arrow"


    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender !is Player) return false

        val uuid = sender.uniqueId
        val entityType = stringToEntityType(args[0])
        config.config.playerBowProjectiles[uuid.toString()] = entityType

        sender.sendMessage("Your Bow Projectile was set to: ${entityType.toString().lowercase().replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }}".purple)

        return true
    }

     private fun stringToEntityType(name: String): EntityType {
        for (et in EntityType.values()) {
            if (et.name.equals(name, true)) {
                return et
            }
        }

        return EntityType.ARROW
    }
}