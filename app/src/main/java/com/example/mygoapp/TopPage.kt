package com.example.mygoapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mygoapp.view.WebviewScreen

data class Topic(val name: String)

class TopPage: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TopPage {
                TopicChip(topic = Topic("Sample Topic"))
                TopPageView()
            }
        }
    }
}

@Composable
fun TopPage(content: @Composable () -> Unit) {
    content()
}

@Composable
fun TopPageView() {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("", style = MaterialTheme.typography.headlineLarge)
        }
        BannerCardLink(
            imageId = R.drawable.mygo_banner,
            url = "https://bang-dream.bushimo.jp/mygo/",
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(10.dp)
        )
    }
}

@Composable
fun BannerCardLink(imageId: Int, url: String, modifier: Modifier = Modifier) {
    val context = LocalContext.current

    Card(
        modifier = modifier
            .padding(10.dp)
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable {
                val intent = Intent(context, WebviewScreen::class.java).apply {
                    putExtra("url", url)
                }
                context.startActivity(intent)
            },
        shape = RoundedCornerShape(3.dp),
        elevation = CardDefaults.cardElevation(3.dp)
    ) {
        Image(
            painter = painterResource(id = imageId),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(150.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(3.dp))
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BannerCardPreview() {
    BannerCardLink(imageId = R.drawable.mygo_banner, url = "https://bang-dream.bushimo.jp/mygo/")
}

@Composable
fun TopicChip(topic: Topic) {
    Card {
        Row {
            Text(text = topic.name)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TopPage {
        TopicChip(topic = Topic("Preview Topic"))
    }
}