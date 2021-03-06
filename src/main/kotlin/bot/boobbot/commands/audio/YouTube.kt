package bot.boobbot.commands.audio

import bot.boobbot.BoobBot.Companion.playerManager
import bot.boobbot.audio.AudioLoader
import bot.boobbot.entities.framework.Category
import bot.boobbot.entities.framework.CommandProperties
import bot.boobbot.entities.framework.Context
import bot.boobbot.utils.Formats
import bot.boobbot.entities.framework.VoiceCommand

@CommandProperties(
    description = "Searches YouTube for videos to play <:p_:475801484282429450> ",
    aliases = ["yt"],
    nsfw = false,
    category = Category.AUDIO,
    guildOnly = true,
    donorOnly = true
)
class YouTube : VoiceCommand {
    override fun execute(ctx: Context) {
        if (!performVoiceChecks(ctx)) {
            return
        }

        if (ctx.args.firstOrNull()?.isEmpty() != false) {
            return ctx.send(Formats.error("Gotta specify a search query, whore"))
        }

        playerManager.loadItem("ytsearch:${ctx.args.joinToString(" ")}", AudioLoader(ctx))
    }
}
