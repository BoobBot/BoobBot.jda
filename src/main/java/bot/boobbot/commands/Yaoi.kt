package bot.boobbot.commands

import bot.boobbot.flight.CommandProperties
import bot.boobbot.models.BbApiCommand

@CommandProperties(description = "Boy love.", nsfw = true)
class Yaoi : BbApiCommand("yaoi")