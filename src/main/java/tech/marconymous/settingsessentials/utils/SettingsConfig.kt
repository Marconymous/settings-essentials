package tech.marconymous.settingsessentials.utils

import org.bukkit.Bukkit
import org.bukkit.command.ConsoleCommandSender

class SettingsConfig {
    val CONSOLE: ConsoleCommandSender = Bukkit.getConsoleSender()
    val onlinePlayers get() = Bukkit.getOnlinePlayers()

    fun broadCast(message: String) {
        for (player in onlinePlayers) {
            player.sendMessage(message)
        }
    }

    fun debug(obj: Any) {
        CONSOLE.sendMessage(obj.toString())
    }
}