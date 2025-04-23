package io.cypherbyte.cypherbyte

import kotlinx.browser.window


actual fun getScreenDimensions(): Pair<Int, Int> {
    return Pair(window.screen.width, window.screen.height)
}

actual fun getScreenWindowDimensions(): Pair<Int, Int> {
    return Pair(window.innerWidth, window.innerHeight)
}