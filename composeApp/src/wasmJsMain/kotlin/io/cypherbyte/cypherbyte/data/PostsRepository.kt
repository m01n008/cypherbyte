package io.cypherbyte.cypherbyte.data

import kotlinx.browser.window
import kotlinx.coroutines.await
import kotlinx.serialization.json.Json
import org.w3c.fetch.Response
import kotlinx.browser.*



actual object PostsRepo {

    private const val INDEX_URL =
        "https://raw.githubusercontent.com/m01n008/cypherbyte/main/posts/index.json"
    private const val POST_BASE_URL =
        "https://raw.githubusercontent.com/m01n008/cypherbyte/main/posts/"
/*
    private const val INDEX_URL = "./posts/index.json"
    private const val POST_BASE_URL = "./posts/"
*/

    actual suspend fun getPostIndex(): List<BlogPostMeta> {
     /*
        val response: Response = window.fetch(INDEX_URL).await()
        val text: String = response.text().await()
        return Json.decodeFromString(text)
        */

        val response: Response = window.fetch(INDEX_URL).await()
        val rawText = response.text().await<JsAny?>()

        try {
            val decoded = Json {
                ignoreUnknownKeys = true
                isLenient = true
            }.decodeFromString<List<BlogPostMeta>>(rawText.toString())

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
        val rawText = response.text().await<JsAny?>()
       try {
           println("getPostContent Success: ${rawText.toString()}")
           return rawText.toString()

       } catch (e: Throwable) {
           println("getPostContent Failed: ${e.message}")
           println("🧪 Raw text: $rawText")
           return ""
       }



    }


}
