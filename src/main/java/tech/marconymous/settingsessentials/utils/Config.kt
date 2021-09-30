package tech.marconymous.settingsessentials.utils

import org.bukkit.Bukkit
import org.bukkit.command.ConsoleCommandSender
import org.bukkit.entity.EntityType
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

class Config {
    private val console: ConsoleCommandSender = Bukkit.getConsoleSender()
    private val onlinePlayers: MutableCollection<out Player> get() = Bukkit.getOnlinePlayers()
    val bowProjectiles = HashMap<ItemStack, EntityType>()

    fun broadCast(message: String) {
        for (player in onlinePlayers) {
            player.sendMessage(message)
        }
    }

    fun debug(obj: Any) {
        console.sendMessage(obj.toString())
    }
}