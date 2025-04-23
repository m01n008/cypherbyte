package io.cypherbyte.cypherbyte.data

data class ScreenInfo(
    val width: Int,
    val height: Int
    )
{
    val isMobile get() = width < 600
    val isTablet get() = width in 600..960
    val isShort get()  = width < 600

}


