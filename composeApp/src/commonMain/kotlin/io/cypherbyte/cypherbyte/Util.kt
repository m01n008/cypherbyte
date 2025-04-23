package io.cypherbyte.cypherbyte

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import io.cypherbyte.cypherbyte.data.ScreenInfo

expect fun getScreenDimensions() : Pair<Int, Int>
expect fun getScreenWindowDimensions(): Pair<Int, Int>

@Composable
fun rememberScreenInfo(): ScreenInfo{
    val (width, height) = getScreenDimensions()
    return remember { ScreenInfo(width, height) }

}
@Composable
fun rememberScreenWindowInfo(): ScreenInfo{
    val (width, height) = getScreenWindowDimensions()
    return remember { ScreenInfo(width, height) }

}