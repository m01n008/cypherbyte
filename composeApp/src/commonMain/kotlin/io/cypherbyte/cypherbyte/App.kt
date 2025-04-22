package io.cypherbyte.cypherbyte

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cypherbyte.composeapp.generated.resources.Res
import cypherbyte.composeapp.generated.resources.cb
import cypherbyte.composeapp.generated.resources.cypherbyte_logo_text
import org.jetbrains.compose.ui.tooling.preview.Preview
import io.cypherbyte.cypherbyte.ui.BlogDetail
import io.cypherbyte.cypherbyte.ui.BlogList
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource


/*
@Composable
@Preview
fun App() {
    MaterialTheme {
        var showContent by remember { mutableStateOf(false) }
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = { showContent = !showContent }) {
                Text("Click me!")
            }
            AnimatedVisibility(showContent) {
                val greeting = remember { Greeting().greet() }
                Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(painterResource(Res.drawable.compose_multiplatform), null)
                    Text("Compose: $greeting")
                }
            }
        }
    }
}
*/
@Composable
@Preview
fun App() {
    MaterialTheme {
        var selectedPostId by remember { mutableStateOf<String?>(null) }

        Column {
            // Header Bar
            Scaffold(
                topBar = {
                    TopAppBar(
                        backgroundColor = Color.White,
                        contentColor = Color.Black, // Use black so text/icons are visible
                        title = {
                            Image(
                                painter = painterResource(Res.drawable.cypherbyte_logo_text),
                                contentDescription = "CypherByte Logo",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(48.dp) // Keep it compact
                            )
                        }
                    )
                }
            ) { innerPadding ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding),
                        //.padding(top = 16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        "Pioneering Cyber News & Intelligence for a Safer, Smarter Future",
                        style = MaterialTheme.typography.subtitle2,
                        color = Color.Gray,
                        modifier = Modifier.padding(16.dp)
                    )
                }

                // Body Content
                Box(Modifier
                    .padding(innerPadding)
                    .padding(top = 32.dp)) {
                    if (selectedPostId == null) {
                        BlogList(onPostClick = { selectedPostId = it })
                    } else {
                        BlogDetail(postId = selectedPostId!!) {
                            selectedPostId = null
                        }
                    }
                }
            }





        }
    }
}

