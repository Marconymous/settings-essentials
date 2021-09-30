package tech.marconymous.settingsessentials

import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin
import tech.marconymous.settingsessentials.functions.entitybow.EntityBowCommand
import tech.marconymous.settingsessentials.functions.entitybow.EntityBowEvent
import tech.marconymous.settingsessentials.functions.entitybow.EntityBowTabCompletion
import tech.marconymous.settingsessentials.functions.mobspawn.MobSpawn
import tech.marconymous.settingsessentials.functions.randomevents.ItemBreak
import tech.marconymous.settingsessentials.functions.serverping.ServerPing
import tech.marconymous.settingsessentials.functions.sleep.SleepEvent
import tech.marconymous.settingsessentials.functions.whitelist.WhitelistCommand
import tech.marconymous.settingsessentials.interfaces.CommandExecutor
import tech.marconymous.settingsessentials.interfaces.EventContainer
import tech.marconymous.settingsessentials.string.green
import tech.marconymous.settingsessentials.string.red
import tech.marconymous.settingsessentials.utils.SettingsConfig

class SettingsEssentials : JavaPlugin() {
    private val commands = HashMap<String, CommandExecutor>()
    val config = SettingsConfig()

    override fun onEnable() {
        Bukkit.getConsoleSender().sendMessage("SettingsEssentials loaded!".green)
        registerCommandExecutor(WhitelistCommand(this))
        registerCommandExecutor(EntityBowCommand(this))
        getCommand("arrow")?.tabCompleter = EntityBowTabCompletion()
        registerEvent(SleepEvent(this))
        registerEvent(ServerPing(this))
        registerEvent(ItemBreak(this))
        registerEvent(EntityBowEvent(this))
        registerEvent(MobSpawn(this))
    }

    override fun onDisable() {
        Bukkit.getConsoleSender().sendMessage("SettingsEssentials unloaded!".red)
    }

    private fun registerEvent(eventListener: EventContainer) {
        Bukkit.getServer().pluginManager.registerEvents(eventListener, this)
    }

    private fun registerCommandExecutor(cmdExec: CommandExecutor) {
        this.getCommand(cmdExec.command)?.setExecutor(cmdExec)
        commands[cmdExec.command] = cmdExec
    }
}