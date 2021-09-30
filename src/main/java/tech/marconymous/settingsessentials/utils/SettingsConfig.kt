package tech.marconymous.settingsessentials.utils

import org.bukkit.Bukkit
import org.bukkit.command.ConsoleCommandSender
import org.bukkit.entity.EntityType

class SettingsConfig {
    val CONSOLE: ConsoleCommandSender = Bukkit.getConsoleSender()
    val onlinePlayers get() = Bukkit.getOnlinePlayers()
    val playerBowProjectiles = HashMap<String, EntityType>()

    fun broadCast(message: String) {
        for (player in onlinePlayers) {
            player.sendMessage(message)
        }
    }

    fun debug(obj: Any) {
        CONSOLE.sendMessage(obj.toString())
    }
}