package tech.marconymous.settingsessentials.interfaces

class CommandContainer constructor(
    val cmdExecutor: CommandExecutor,
    val tabInterface: TabInterface? = null,
) : HasCommand()