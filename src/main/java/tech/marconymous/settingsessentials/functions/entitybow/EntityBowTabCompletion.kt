package tech.marconymous.settingsessentials.functions.entitybow

import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.entity.EntityType
import tech.marconymous.settingsessentials.SettingsEssentials
import tech.marconymous.settingsessentials.interfaces.TabInterface

class EntityBowTabCompletion(plugin: SettingsEssentials) : TabInterface(plugin) {
    override fun onTabComplete(
        sender: CommandSender,
        command: Command,
        alias: String,
        args: Array<out String>
    ): List<String> {
        if (command.name != this.command) return ArrayList()

        if (args.size > 1) return ArrayList()
        val list = ArrayList<String>()

        for (t in EntityType.values()) {
            if (t.name.startsWith(args[0], true))
                list.add(t.name.lowercase())
        }
        return list
    }
}