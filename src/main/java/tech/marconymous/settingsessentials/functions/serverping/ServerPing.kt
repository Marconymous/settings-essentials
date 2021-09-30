package tech.marconymous.settingsessentials.functions.serverping

import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.server.ServerListPingEvent
import tech.marconymous.settingsessentials.SettingsEssentials
import tech.marconymous.settingsessentials.interfaces.EventContainer

class ServerPing(plugin: SettingsEssentials) : EventContainer(plugin) {
    @EventHandler
    fun onServerPing(e: ServerListPingEvent) {
        e.maxPlayers = Bukkit.getOnlinePlayers().size + 1
    }
}