package tech.marconymous.settingsessentials.functions.hook

import org.bukkit.event.EventHandler
import org.bukkit.event.player.PlayerFishEvent
import org.bukkit.util.Vector
import tech.marconymous.settingsessentials.SettingsEssentials
import tech.marconymous.settingsessentials.interfaces.EventContainer

class HookEvent(plugin: SettingsEssentials) : EventContainer(plugin) {

    @EventHandler
    fun onHook(e: PlayerFishEvent) {
        if (e.state != PlayerFishEvent.State.IN_GROUND) return

        val player = e.player
        val b = e.hook.location

        player.location.let { it ->
            val x = div(b.x, it.x)
            var y: Double
            div(b.y, it.y).let {
                y = if (it <= 1) {
                    1.0
                } else {
                    it
                }
            }
            val z = div(b.z, it.z)

            val velocity = Vector(
                x, y, z
            )
            player.velocity = velocity
        }
    }

    private fun div(b: Double, p: Double): Double {
        return (b - p) / 5
    }
}