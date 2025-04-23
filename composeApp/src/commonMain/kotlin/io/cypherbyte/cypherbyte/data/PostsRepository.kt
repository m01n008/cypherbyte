package io.cypherbyte.cypherbyte.data
import kotlinx.serialization.Serializable

@Serializable
data class BlogPostMeta(
    val id: String? = null,
    val title: String? = null,
    val date: String? = null,
    val filename: String? = null
)

expect object PostsRepo {
    suspend fun getPostIndex(): List<BlogPostMeta>
    suspend fun getPostContent(filename: String?): String
}