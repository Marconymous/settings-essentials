package tech.marconymous.settingsessentials.functions.randomevents

import org.bukkit.event.EventHandler
import org.bukkit.event.player.PlayerItemBreakEvent
import tech.marconymous.settingsessentials.SettingsEssentials
import tech.marconymous.settingsessentials.interfaces.EventContainer
import tech.marconymous.settingsessentials.utils.Config

class ItemBreak(plugin: SettingsEssentials) : EventContainer(plugin) {

    @EventHandler
    fun onItemBreak(e: PlayerItemBreakEvent) {
        val player = e.player
        val item: String = e.brokenItem.type.name
        plugin.config.broadCast("${player.name} het eifach $item kaputt gmacht")
    }
}