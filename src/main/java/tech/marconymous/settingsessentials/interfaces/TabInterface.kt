package tech.marconymous.settingsessentials.interfaces

import org.bukkit.command.TabCompleter
import tech.marconymous.settingsessentials.SettingsEssentials

abstract class TabInterface(val plugin: SettingsEssentials) : TabCompleter, HasCommand() {
}