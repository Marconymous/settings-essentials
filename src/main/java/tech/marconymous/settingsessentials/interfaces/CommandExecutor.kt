package tech.marconymous.settingsessentials.interfaces

import org.bukkit.command.CommandExecutor
import tech.marconymous.settingsessentials.SettingsEssentials

abstract class CommandExecutor(
    val plugin: SettingsEssentials
) : CommandExecutor, HasCommand()