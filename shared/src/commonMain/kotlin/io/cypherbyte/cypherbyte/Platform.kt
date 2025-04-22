package io.cypherbyte.cypherbyte

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform