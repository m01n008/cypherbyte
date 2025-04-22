package io.cypherbyte.cypherbyte.ui

import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.cypherbyte.cypherbyte.data.dummyPosts

@Composable
fun BlogDetail(postId: String, onBack: () -> Unit) {
    val post = dummyPosts.find { it.id == postId }

    Column(Modifier.padding(16.dp)) {
        Button(onClick = onBack) { Text("Back") }

        Spacer(Modifier.height(12.dp))
        post?.let {
            Text(it.title, style = MaterialTheme.typography.h5)
            Text(it.date, style = MaterialTheme.typography.body2)
            Spacer(Modifier.height(12.dp))
            Text(it.content) // Later: render this as real Markdown
        } ?: Text("Post not found.")
    }
}