package io.cypherbyte.cypherbyte.data

import kotlinx.browser.window
import kotlinx.coroutines.await
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import org.w3c.fetch.Response

@Serializable
data class BlogPostMeta(
    val id: String,
    val title: String,
    val date: String,
    val filename: String
)

actual object PostsRepo {
    private const val INDEX_URL =
        "https://raw.githubusercontent.com/m01n008/cypherbyte/main/posts/index.json"
    private const val POST_BASE_URL =
        "https://raw.githubusercontent.com/m01n008/cypherbyte/main/posts/"

   actual suspend fun getPostIndex(): List<BlogPostMeta> {
        val response: Response = window.fetch(INDEX_URL).await()
        val text: String = response.text().await()
        return Json.decodeFromString(text)
    }

   actual suspend fun getPostContent(filename: String): String {
        val response: Response = window.fetch(POST_BASE_URL + filename).await()
        return response.text().await()
    }
}
