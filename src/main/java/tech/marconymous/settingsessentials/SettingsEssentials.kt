package tech.marconymous.settingsessentials

import jdk.jfr.Event
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.Bukkit
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
        registerEvent(SleepEvent(this))
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