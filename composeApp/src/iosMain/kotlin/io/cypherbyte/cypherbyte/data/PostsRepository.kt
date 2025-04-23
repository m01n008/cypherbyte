package io.cypherbyte.cypherbyte.data




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
       TODO()
    }

   actual suspend fun getPostContent(filename: String): String {
      TODO()
    }
}
