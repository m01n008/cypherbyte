package io.cypherbyte.cypherbyte.data

import kotlinx.serialization.json.Json

data class BlogPostMeta(
    val id: String? = null,
    val title: String? = null,
    val date: String? = null,
    val filename: String? = null
)

actual object PostsRepo {
    /*
       private const val INDEX_URL =
           "https://raw.githubusercontent.com/m01n008/cypherbyte/main/posts/index.json"
       private const val POST_BASE_URL =
           "https://raw.githubusercontent.com/m01n008/cypherbyte/main/posts/"
   */
    private const val INDEX_URL = "./posts/index.json"
    private const val POST_BASE_URL = "./posts/"


    actual suspend fun getPostIndex(): List<BlogPostMeta> {
        /*
           val response: Response = window.fetch(INDEX_URL).await()
           val text: String = response.text().await()
           return Json.decodeFromString(text)
           */
        val response: Response = window.fetch(INDEX_URL).await()
        val rawText: String = response.text().await()

        try {
            val decoded = Json {
                ignoreUnknownKeys = true
                isLenient = true
            }.decodeFromString<List<BlogPostMeta>>(rawText)

            println("✅ Decoded posts: $decoded")
            return decoded

        } catch (e: Throwable) {
            println("❌ Failed to decode JSON: ${e.message}")
            println("🧪 Raw text: $rawText")
            return emptyList()
        }


    }

    actual suspend fun getPostContent(filename: String?): String {
        val response: Response = window.fetch(POST_BASE_URL + filename).await()
        return response.text().await()
    }


}
