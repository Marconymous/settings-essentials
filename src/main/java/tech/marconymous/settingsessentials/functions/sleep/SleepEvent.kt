package tech.marconymous.settingsessentials.functions.sleep

import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.player.PlayerBedEnterEvent
import tech.marconymous.settingsessentials.SettingsEssentials
import tech.marconymous.settingsessentials.interfaces.EventContainer

class SleepEvent(plugin: SettingsEssentials) : EventContainer(plugin) {
    @EventHandler
    fun playerSleep(e: PlayerBedEnterEvent) {
        if (e.bedEnterResult != PlayerBedEnterEvent.BedEnterResult.OK) return

        val world = e.player.world
        val relativeTime = 24000 - world.time

        Bukkit.getScheduler().runTaskLater(plugin, Runnable { world.fullTime = world.fullTime + relativeTime }, 1000)
    }
}