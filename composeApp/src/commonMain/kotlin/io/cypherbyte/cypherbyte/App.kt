import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.style.TextAlign
import cypherbyte.composeapp.generated.resources.Res
import cypherbyte.composeapp.generated.resources.cypherbyte_logo_text
import io.cypherbyte.cypherbyte.data.BlogPostMeta
import io.cypherbyte.cypherbyte.rememberScreenWindowInfo
import io.cypherbyte.cypherbyte.ui.BlogDetail
import io.cypherbyte.cypherbyte.ui.BlogList
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
@Preview
fun App() {
    val screenWindow = rememberScreenWindowInfo()
    var selectedPost by remember { mutableStateOf<BlogPostMeta?>(null) }
    MaterialTheme {

        Scaffold(
            topBar = {
                TopAppBar(
                    backgroundColor = Color.White,
                    contentColor = Color.Black,
                    elevation = 4.dp,
                    title = {
                        Image(
                            painter = painterResource(Res.drawable.cypherbyte_logo_text),
                            contentDescription = "CypherByte Logo",
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(if (screenWindow.isMobile) 40.dp else 48.dp)
                        )
                    }
                )
            }
        ) { innerPadding ->

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(horizontal = if (screenWindow.isMobile) 8.dp else 24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Pioneering Cyber News & Intelligence for a Safer, Smarter Future",
                    style = MaterialTheme.typography.subtitle2.copy(
                        fontSize = if (screenWindow.isMobile) 12.sp else 14.sp
                    ),
                    color = Color.Gray,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(top = 16.dp, bottom = 24.dp)
                        .fillMaxWidth()
                )

                // Body Content
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 32.dp)
                ) {
                    /*
                    if (selectedPostId == null) {
                        BlogList(onPostClick = { selectedPostId = it })
                    } else {
                        BlogDetail(postId = selectedPostId!!) {
                            selectedPostId = null
                        }
                    }
                    */

                    if (selectedPost != null) {
                        BlogDetail(postMeta = selectedPost!!){ selectedPost = null }
                    } else {
                        BlogList(onPostClick = { selectedPost = it })
                    }
                }
            }
        }
    }
}
