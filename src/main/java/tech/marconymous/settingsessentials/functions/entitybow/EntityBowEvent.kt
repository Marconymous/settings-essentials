package tech.marconymous.settingsessentials.functions.entitybow

import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.entity.EntityShootBowEvent
import tech.marconymous.settingsessentials.SettingsEssentials
import tech.marconymous.settingsessentials.interfaces.EventContainer

class EntityBowEvent(plugin: SettingsEssentials) : EventContainer(plugin) {
    @EventHandler
    fun onBowShot(e: EntityShootBowEvent) {
        if (e.entity !is Player)
            return

        val bow = e.bow

        val type = plugin.config.bowProjectiles[bow] ?: return

        val entity = e.entity.world.spawnEntity(e.projectile.location, type)

        entity.velocity = e.projectile.velocity

        e.projectile = entity
    }
}