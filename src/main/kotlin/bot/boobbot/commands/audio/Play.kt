package bot.boobbot.commands.audio

import bot.boobbot.BoobBot.Companion.playerManager
import bot.boobbot.audio.AudioLoader
import bot.boobbot.flight.Category
import bot.boobbot.flight.CommandProperties
import bot.boobbot.flight.Context
import bot.boobbot.misc.Formats
import bot.boobbot.misc.Utils
import bot.boobbot.misc.toUriOrNull
import bot.boobbot.models.VoiceCommand

@CommandProperties(
    description = "Plays from a PornHub or RedTube URL (and YouTube if Donor)",
    category = Category.AUDIO,
    guildOnly = true,
    nsfw = true
)
class Play : VoiceCommand {

    override fun execute(ctx: Context) {
        val shouldPlay = performVoiceChecks(ctx)

        if (!shouldPlay) {
            return
        }

        if (ctx.args.isEmpty() || ctx.args[0].isEmpty()) {
            return ctx.send("Specify something to play, whore.\nSupported sites: `pornhub`, `redtube`, `youtube`")
        }

        val player = ctx.audioPlayer
        val query = ctx.args[0].replace("<", "").replace(">", "")

        if (!Utils.checkDonor(ctx.message) && isYouTubeTrack(query)) {
            return ctx.send(
                Formats.error(
                    " Sorry YouTube music is only available to our Patrons.\n<:p_:475801484282429450> "
                            + "Stop being a cheap fuck and join today! https://www.patreon.com/OfficialBoobBot"
                )
            )
        }

        playerManager.loadItem(query, AudioLoader(player, ctx))
    }

    private fun isYouTubeTrack(query: String): Boolean {
        val uri = query.toUriOrNull()
        val domain = if (uri?.host?.startsWith("www.") == true) {
            uri.host?.substring(4)
        } else {
            uri?.host
        }

        return query.startsWith("ytsearch:") ||
                domain?.let { it == "youtube.com" || domain == "youtu.be" } ?: false
    }

}
