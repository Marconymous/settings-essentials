package tech.marconymous.settingsessentials.functions.mobspawn

import org.bukkit.entity.Creeper
import org.bukkit.event.EventHandler
import org.bukkit.event.entity.EntitySpawnEvent
import tech.marconymous.settingsessentials.SettingsEssentials
import tech.marconymous.settingsessentials.interfaces.EventContainer

class MobSpawn(plugin: SettingsEssentials) : EventContainer(plugin) {

    @EventHandler
    fun onMobSpawn(e: EntitySpawnEvent) {
        if (e.entity is Creeper) {
            val c = e.entity as Creeper
            c.isPowered = true
            c.explosionRadius = c.explosionRadius * 10
        }
    }
}