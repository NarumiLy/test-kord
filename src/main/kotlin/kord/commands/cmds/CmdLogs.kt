package kord.commands.cmds

import com.gitlab.kordlib.core.Kord
import com.gitlab.kordlib.core.event.message.MessageCreateEvent
import kord.api.Bot
import kord.cmdsExecuted
import kord.commands.Command

class CmdLogs : Command("cmdlogs") {

    override suspend fun execute(event: MessageCreateEvent, client: Kord) {
        val message = event.message;
        var execCmd = ""

        if(Bot().isOwner("${message.author!!.id}")) return

        for(exec in cmdsExecuted) {
            val kordcmd = "kord.commands.cmds.".length
            val lengthExec = exec.key.length - 1

            execCmd += "\n" + "${exec.key.slice(kordcmd..lengthExec)} executed ${exec.value} time(s)"
        }

        message.getChannel().createMessage(execCmd)
    }
}
