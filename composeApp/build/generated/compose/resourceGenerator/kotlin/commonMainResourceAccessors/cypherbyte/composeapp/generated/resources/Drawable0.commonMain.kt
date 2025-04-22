@file:OptIn(org.jetbrains.compose.resources.InternalResourceApi::class)

package cypherbyte.composeapp.generated.resources

import kotlin.OptIn
import kotlin.String
import kotlin.collections.MutableMap
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.InternalResourceApi

private object CommonMainDrawable0 {
  public val cb: DrawableResource by 
      lazy { init_cb() }

  public val compose_multiplatform: DrawableResource by 
      lazy { init_compose_multiplatform() }

  public val cypherbyte_logo_text: DrawableResource by 
      lazy { init_cypherbyte_logo_text() }
}

@InternalResourceApi
internal fun _collectCommonMainDrawable0Resources(map: MutableMap<String, DrawableResource>) {
  map.put("cb", CommonMainDrawable0.cb)
  map.put("compose_multiplatform", CommonMainDrawable0.compose_multiplatform)
  map.put("cypherbyte_logo_text", CommonMainDrawable0.cypherbyte_logo_text)
}

internal val Res.drawable.cb: DrawableResource
  get() = CommonMainDrawable0.cb

private fun init_cb(): DrawableResource = org.jetbrains.compose.resources.DrawableResource(
  "drawable:cb",
    setOf(
      org.jetbrains.compose.resources.ResourceItem(setOf(),
    "composeResources/cypherbyte.composeapp.generated.resources/drawable/cb.png", -1, -1),
    )
)

internal val Res.drawable.compose_multiplatform: DrawableResource
  get() = CommonMainDrawable0.compose_multiplatform

private fun init_compose_multiplatform(): DrawableResource =
    org.jetbrains.compose.resources.DrawableResource(
  "drawable:compose_multiplatform",
    setOf(
      org.jetbrains.compose.resources.ResourceItem(setOf(),
    "composeResources/cypherbyte.composeapp.generated.resources/drawable/compose-multiplatform.xml", -1, -1),
    )
)

internal val Res.drawable.cypherbyte_logo_text: DrawableResource
  get() = CommonMainDrawable0.cypherbyte_logo_text

private fun init_cypherbyte_logo_text(): DrawableResource =
    org.jetbrains.compose.resources.DrawableResource(
  "drawable:cypherbyte_logo_text",
    setOf(
      org.jetbrains.compose.resources.ResourceItem(setOf(),
    "composeResources/cypherbyte.composeapp.generated.resources/drawable/cypherbyte_logo_text.png", -1, -1),
    )
)
