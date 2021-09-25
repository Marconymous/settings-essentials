package tech.marconymous.settingsessentials.functions.sleep

import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerBedEnterEvent
import tech.marconymous.settingsessentials.SettingsEssentials
import tech.marconymous.settingsessentials.interfaces.EventContainer
import tech.marconymous.settingsessentials.string.yellow
import java.util.*
import kotlin.collections.ArrayList
import java.util.TimerTask as TimerTask

class SleepEvent(plugin: SettingsEssentials) : EventContainer(plugin) {
    @EventHandler
    fun playerSleep(e: PlayerBedEnterEvent) {
        val players = plugin.config.onlinePlayers
        val slumberingPlayers = ArrayList<Player>()

        if (e.bedEnterResult != PlayerBedEnterEvent.BedEnterResult.OK) return

        for (player in players) {
            if (player.isSleeping) {
                slumberingPlayers.add(player)
            }
        }

        e.player.sendMessage("slumb = ${slumberingPlayers.size} ; total = ${players.size}")
        if (slumberingPlayers.size + 1 >= players.size / 2) {
            e.player.world.time = 1000
            plugin.config.broadCast("MultiPlayerSleep: Slept through the night!".yellow)
        } else {
            plugin.config.broadCast("MultiplayerSleep: ${slumberingPlayers.size}/${players.size / 2} players are sleeping!".yellow)
        }
    }
}