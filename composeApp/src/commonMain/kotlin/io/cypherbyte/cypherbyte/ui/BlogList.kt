package io.cypherbyte.cypherbyte.ui

import androidx.compose.runtime.*
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.cypherbyte.cypherbyte.data.dummyPosts

@Composable
fun BlogList(onPostClick: (String) -> Unit) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Latest Posts", style = MaterialTheme.typography.h5)
        Spacer(Modifier.height(12.dp))

        dummyPosts.forEach { post ->
            Card(
                Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .clickable { onPostClick(post.id) },
                elevation = 4.dp
            ) {
                Column(Modifier.padding(16.dp)) {
                    Text(post.title, style = MaterialTheme.typography.h6)
                    Text(post.date, style = MaterialTheme.typography.body2)
                }
            }
        }
    }
}