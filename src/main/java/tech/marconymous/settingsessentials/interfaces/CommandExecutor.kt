package tech.marconymous.settingsessentials.interfaces

import org.bukkit.command.CommandExecutor
import tech.marconymous.settingsessentials.SettingsEssentials
import tech.marconymous.settingsessentials.utils.SettingsConfig

abstract class CommandExecutor(val config: SettingsEssentials) : CommandExecutor {
    val command: String = ""
}
