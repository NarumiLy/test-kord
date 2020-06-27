package kord.commands.cmds

import com.gitlab.kordlib.core.Kord
import com.gitlab.kordlib.core.event.message.MessageCreateEvent
import kord.commands.Command

class Ping : Command("ping") {

    override suspend fun execute(event: MessageCreateEvent, client: Kord) {
        val msg = event.message;

        msg.getChannel().createMessage("Pong ! :ping_pong: ${client.gateway.averagePing}")
    }
}

