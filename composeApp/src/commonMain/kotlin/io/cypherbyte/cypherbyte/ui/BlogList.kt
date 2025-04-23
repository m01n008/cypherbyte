package io.cypherbyte.cypherbyte.ui

import androidx.compose.runtime.*
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.cypherbyte.cypherbyte.data.dummyPosts
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.unit.sp
import io.cypherbyte.cypherbyte.data.BlogPostMeta
import io.cypherbyte.cypherbyte.data.PostsRepo
import io.cypherbyte.cypherbyte.rememberScreenWindowInfo

/*
@Composable
fun BlogList(onPostClick: (String) -> Unit) {
    val screenWindow = rememberScreenWindowInfo()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = if (screenWindow.isMobile) 8.dp else 24.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            "Latest Posts",
            style = MaterialTheme.typography.h5.copy(fontSize = if (screenWindow.isMobile) 18.sp else 22.sp),
            modifier = Modifier.padding(vertical = 16.dp)
        )
        LaunchedEffect(Unit){
         val posts = PostsRepo.getPostIndex()
         println(posts)
            val post = PostsRepo.getPostContent(posts.get())
        }

        dummyPosts.forEach { post ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .clickable { onPostClick(post.id) },
                elevation = 4.dp
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        post.title,
                        style = MaterialTheme.typography.h6.copy(fontSize = if (screenWindow.isMobile) 14.sp else 16.sp)
                    )
                    Spacer(Modifier.height(4.dp))
                    Text(
                        post.date,
                        style = MaterialTheme.typography.body2.copy(fontSize = if (screenWindow.isMobile) 12.sp else 14.sp)
                    )
                }
            }
        }
    }
}
*/

@Composable
fun BlogList(onPostClick: (BlogPostMeta) -> Unit) {
    val screenWindow = rememberScreenWindowInfo()

    // Local state for fetched posts
    var posts by remember { mutableStateOf<List<BlogPostMeta>>(emptyList()) }
    var loading by remember { mutableStateOf(true) }

    // Fetch posts once
    LaunchedEffect(Unit) {
        posts = PostsRepo.getPostIndex()
        loading = false
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = if (screenWindow.isMobile) 8.dp else 24.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            "Latest Posts",
            style = MaterialTheme.typography.h5.copy(fontSize = if (screenWindow.isMobile) 18.sp else 22.sp),
            modifier = Modifier.padding(vertical = 16.dp)
        )

        if (loading) {
            CircularProgressIndicator(modifier = Modifier.padding(16.dp))
        } else {
            posts.forEach { post ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                        .clickable { onPostClick(post) },
                    elevation = 4.dp
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        post.title?.let {
                            Text(
                                it,
                                style = MaterialTheme.typography.h6.copy(fontSize = if (screenWindow.isMobile) 14.sp else 16.sp)
                            )
                        }
                        Spacer(Modifier.height(4.dp))
                        post.date?.let {
                            Text(
                                it,
                                style = MaterialTheme.typography.body2.copy(fontSize = if (screenWindow.isMobile) 12.sp else 14.sp)
                            )
                        }
                    }
                }
            }
        }
    }
}


