package kord.api

import kord.api.Config.CREATORID

class Bot {

    fun isOwner(targetID: String): Boolean {
        return targetID === CREATORID;
    }
}