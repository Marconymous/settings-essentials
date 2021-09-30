package tech.marconymous.settingsessentials.functions.entitybow

import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.command.TabCompleter
import org.bukkit.entity.EntityType

class EntityBowTabCompletion : TabCompleter {
    override fun onTabComplete(
        sender: CommandSender,
        command: Command,
        alias: String,
        args: Array<out String>
    ): List<String> {
        val list = ArrayList<String>()

        for (t in EntityType.values()) {
            if (t.name.contains(args[args.size - 1], true))
                list.add(t.name)
        }

        return list
    }
}