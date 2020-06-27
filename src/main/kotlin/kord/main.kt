package kord

import com.gitlab.kordlib.common.entity.Status
import com.gitlab.kordlib.core.Kord
import com.gitlab.kordlib.core.event.gateway.ReadyEvent
import com.gitlab.kordlib.core.event.message.MessageCreateEvent
import com.gitlab.kordlib.core.on
import kord.commands.cmds.*
import kord.api.Config

var cmdsExecuted = mutableMapOf<String, Int>();

    suspend fun main() {
        val client = Kord(Config.TOKEN);
        val cmds = setOf(
                Ping(),
                Help(),
                CmdLogs()
        )


        client.on<ReadyEvent> {

            println("Connected at ${client.getSelf().username} successfully");
        }

        client.on<MessageCreateEvent> {

            for (cmd in cmds) {

                if (cmd.handle(this, client)) {
                    val execValue = cmdsExecuted.getValue(cmd.toString())

                    if (cmdsExecuted.containsKey(cmd.toString())) {

                        cmdsExecuted[cmd.toString()] = execValue + 1;
                        println("$cmd executed $execValue times")
                    } else {

                        cmdsExecuted[cmd.toString()] = 1;
                        println("$cmd executed $execValue times")
                    }
                }
            }
        }

        client.login {
            status = Status.DnD;
            listening(Config.STATUS)
        }
    }


