package bot.boobbot.commands.nsfw

import bot.boobbot.entities.framework.Category
import bot.boobbot.entities.framework.CommandProperties
import bot.boobbot.entities.framework.BbApiCommand

@CommandProperties(
    description = "4K Hotness! <:p_:475801484282429450> ",
    nsfw = true,
    category = Category.GENERAL,
    donorOnly = true
)
class `4K` : BbApiCommand("4k")
