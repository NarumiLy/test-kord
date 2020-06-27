package kord.commands

import com.gitlab.kordlib.core.Kord
import com.gitlab.kordlib.core.event.message.MessageCreateEvent
import kord.api.Config

abstract class Command(private val name: String) {

    suspend fun handle(event: MessageCreateEvent, client: Kord) : Boolean {
        val msg = event.message.content;

        return if(msg.startsWith(Config.PREFIX + name.toLowerCase())) {

            execute(event, client)
            true
        } else {

            false
        }
    }

       abstract suspend fun execute(event: MessageCreateEvent, client: Kord);
}
