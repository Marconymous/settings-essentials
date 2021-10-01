package tech.marconymous.settingsessentials

import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin
import tech.marconymous.settingsessentials.functions.entitybow.EntityBowCommand
import tech.marconymous.settingsessentials.functions.entitybow.EntityBowEvent
import tech.marconymous.settingsessentials.functions.entitybow.EntityBowTabCompletion
import tech.marconymous.settingsessentials.functions.hook.HookEvent
import tech.marconymous.settingsessentials.functions.randomevents.ItemBreak
import tech.marconymous.settingsessentials.functions.serverping.ServerPing
import tech.marconymous.settingsessentials.functions.sleep.SleepEvent
import tech.marconymous.settingsessentials.functions.whitelist.WhitelistCommand
import tech.marconymous.settingsessentials.interfaces.CommandContainer
import tech.marconymous.settingsessentials.interfaces.EventContainer
import tech.marconymous.settingsessentials.string.cyan
import tech.marconymous.settingsessentials.string.green
import tech.marconymous.settingsessentials.string.red
import tech.marconymous.settingsessentials.utils.Config

class SettingsEssentials : JavaPlugin() {
    private val commands = HashMap<String, CommandContainer>()
    val config = Config()

    override fun onEnable() {
        Bukkit.getConsoleSender().sendMessage("SettingsEssentials loaded!".green)
        registerCommand(
            CommandContainer(
                cmdExecutor = WhitelistCommand(this),
                tabInterface = null,
            ), "whitelist"
        )

        registerCommand(
            CommandContainer(
                cmdExecutor = EntityBowCommand(this),
                tabInterface = EntityBowTabCompletion(this),
            ),
            "bow"
        )

        registerEvent(SleepEvent(this))
        registerEvent(ServerPing(this))
        registerEvent(ItemBreak(this))
        registerEvent(EntityBowEvent(this))
        registerEvent(HookEvent(this))
    }

    override fun onDisable() {
        Bukkit.getConsoleSender().sendMessage("SettingsEssentials unloaded!".red)
    }

    private fun registerCommand(commandContainer: CommandContainer, s: String) {
        commandContainer.command = s
        val command = getCommand(commandContainer.command)

        if (command != null) {
            debug("Registering Command (${commandContainer.command}): exec -> ${commandContainer.cmdExecutor::class.simpleName} & tab -> ${if (commandContainer.tabInterface != null) commandContainer.tabInterface::class.simpleName else null}".cyan)
            commands[commandContainer.command] = commandContainer

            commandContainer.cmdExecutor.command = s
            if (commandContainer.tabInterface != null)
                commandContainer.tabInterface.command = s

            command.setExecutor(commandContainer.cmdExecutor)
            command.tabCompleter = commandContainer.tabInterface
        }

    }

    private fun registerEvent(eventContainer: EventContainer) {
        Bukkit.getPluginManager().registerEvents(eventContainer, this)
    }

    fun debug(obj: Any) {
        config.debug(obj)
    }
}