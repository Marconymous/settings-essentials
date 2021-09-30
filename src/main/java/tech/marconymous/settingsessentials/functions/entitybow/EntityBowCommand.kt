package tech.marconymous.settingsessentials.functions.entitybow

import org.bukkit.Material
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.enchantments.Enchantment
import org.bukkit.entity.EntityType
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import tech.marconymous.settingsessentials.SettingsEssentials
import tech.marconymous.settingsessentials.interfaces.CommandExecutor
import tech.marconymous.settingsessentials.string.purple
import java.util.*

class EntityBowCommand(plugin: SettingsEssentials) : CommandExecutor(plugin) {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (command.name != this.command) return true

        if (sender !is Player) return false

        when (args.size) {
            1 -> generateBow(sender, args)
            else -> {
                sender.sendMessage("Please use: ${command.usage}")
            }
        }

        return true
    }

    private fun generateBow(entityType: EntityType): ItemStack? {
        val bow = ItemStack(Material.BOW)
        bow.amount = 1
        bow.addEnchantment(Enchantment.ARROW_INFINITE, 1)

        val itemMeta = bow.itemMeta ?: run { return null }

        val lore = ArrayList<String>()
        lore.add(entityType.name.lowercase())

        itemMeta.setDisplayName("§bEntityShooter: §4${entityType.name.lowercase()}")

        bow.itemMeta = itemMeta

        return bow
    }

    private fun generateBow(sender: Player, args: Array<out String>) {
        val entityType = stringToEntityType(args[0])
        val bow = generateBow(entityType) ?: run { return }
        plugin.config.bowProjectiles[bow] = entityType

        sender.inventory.addItem(bow)

        sender.sendMessage(
            "Your Bow Projectile was set to: ${
                entityType.toString().lowercase()
                    .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
            }".purple
        )
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
