package bot.boobbot.commands.meme

import bot.boobbot.entities.framework.Category
import bot.boobbot.entities.framework.CommandProperties
import bot.boobbot.entities.framework.MemeAvatarCommand

@CommandProperties(description = "aborted.", category = Category.MEME, guildOnly = true)
class Aborted : MemeAvatarCommand("aborted")