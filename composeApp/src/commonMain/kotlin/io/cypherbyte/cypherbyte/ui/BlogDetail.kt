package io.cypherbyte.cypherbyte.ui

import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.cypherbyte.cypherbyte.data.dummyPosts

import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll

import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.style.TextAlign
import io.cypherbyte.cypherbyte.rememberScreenWindowInfo
import io.cypherbyte.cypherbyte.data.PostsRepo
import io.cypherbyte.cypherbyte.data.BlogPostMeta



/*
@Composable
fun BlogDetail(postId: String, onBack: () -> Unit) {
    val post = dummyPosts.find { it.id == postId }
    val screenWindow = rememberScreenWindowInfo()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = if (screenWindow.isMobile) 12.dp else 32.dp, vertical = 16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Button(onClick = onBack) {
            Text("← Back")
        }

        Spacer(Modifier.height(20.dp))

        post?.let {
            Text(
                it.title,
                style = MaterialTheme.typography.h5.copy(fontSize = if (screenWindow.isMobile) 18.sp else 22.sp),
                textAlign = TextAlign.Start,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(Modifier.height(6.dp))

            Text(
                it.date,
                style = MaterialTheme.typography.body2.copy(fontSize = if (screenWindow.isMobile) 12.sp else 14.sp),
                color = MaterialTheme.colors.onSurface.copy(alpha = 0.6f)
            )

            Spacer(Modifier.height(20.dp))

            Text(
                it.content,
                style = MaterialTheme.typography.body1.copy(fontSize = if (screenWindow.isMobile) 14.sp else 16.sp),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Start
            )
        } ?: Text("Post not found.")
    }
}
*/

@Composable
fun BlogDetail(postMeta: BlogPostMeta, onBack: () -> Unit) {
    val screenWindow = rememberScreenWindowInfo()
    var content by remember { mutableStateOf<String?>(null) }
    var isLoading by remember { mutableStateOf(true) }

    // Load post content from remote
    LaunchedEffect(postMeta.filename) {
        content = PostsRepo.getPostContent(postMeta.filename)
        isLoading = false
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = if (screenWindow.isMobile) 12.dp else 32.dp, vertical = 16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Button(onClick = onBack) {
            Text("← Back")
        }

        Spacer(Modifier.height(20.dp))

        postMeta.title?.let {
            Text(
                it,
                style = MaterialTheme.typography.h5.copy(fontSize = if (screenWindow.isMobile) 18.sp else 22.sp),
                textAlign = TextAlign.Start,
                modifier = Modifier.fillMaxWidth()
            )
        }

        Spacer(Modifier.height(6.dp))

        postMeta.date?.let {
            Text(
                it,
                style = MaterialTheme.typography.body2.copy(fontSize = if (screenWindow.isMobile) 12.sp else 14.sp),
                color = MaterialTheme.colors.onSurface.copy(alpha = 0.6f)
            )
        }

        Spacer(Modifier.height(20.dp))

        if (isLoading) {
            CircularProgressIndicator()
        } else {
            Text(
                content ?: "Error loading content.",
                style = MaterialTheme.typography.body1.copy(fontSize = if (screenWindow.isMobile) 14.sp else 16.sp),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Start
            )
        }
    }
}
