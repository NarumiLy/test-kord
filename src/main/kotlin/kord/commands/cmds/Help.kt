package kord.commands.cmds

import com.gitlab.kordlib.common.entity.Snowflake
import com.gitlab.kordlib.core.Kord
import com.gitlab.kordlib.core.behavior.channel.createEmbed
import com.gitlab.kordlib.core.event.message.MessageCreateEvent
import kord.api.Config
import kord.commands.Command
import java.awt.Color
import java.time.Instant

class Help : Command("help") {

    override suspend fun execute(event: MessageCreateEvent, client: Kord) {
        val msg = event.message
        val authorAvatar = msg.author!!.avatar.url


        msg.getChannel().createEmbed {
            color= Color.blue
            title= "Help command"
            description= "List of commands"
            url= Config.GITHUB_ACCOUNT
            timestamp= Instant.now()
            thumbnail { url= authorAvatar }
            footer { text= "Bot made by ${client.getUser(Snowflake(Config.CREATORID))?.tag}"; icon= client.getSelf().avatar.url };
            author { name= msg.author?.username; url= "https://github.com/NarumiLy"; icon= authorAvatar }
            field { name= "H:ping"; value= "A ping cmd."; inline= false }
        }
    }
}