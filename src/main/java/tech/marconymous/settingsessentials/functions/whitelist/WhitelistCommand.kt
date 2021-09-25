package tech.marconymous.settingsessentials.functions.whitelist

import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import tech.marconymous.settingsessentials.SettingsEssentials
import tech.marconymous.settingsessentials.interfaces.CommandExecutor
import tech.marconymous.settingsessentials.string.lime
import tech.marconymous.settingsessentials.string.red

class WhitelistCommand(plugin: SettingsEssentials) : CommandExecutor(plugin) {
    override fun onCommand(sender: CommandSender, cmd: Command, label: String, args: Array<out String>): Boolean {
        if (args.isEmpty()) {
            val whitelist = !Bukkit.getServer().isWhitelistEnforced
            Bukkit.getServer().setWhitelist(whitelist)
            val resp = if (whitelist) "Whitelist has been turned on".lime else "Whitelist has been turned off".red
            sender.sendMessage(resp)
            return false
        }
        return false
    }
}