package com.amaliasrasyid.learn_jetpack_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MaterialDesignComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
        }
    }
}

@Composable
fun NewStory() {
    MaterialTheme() {
        val typography = MaterialTheme.typography
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.pekanbaru),
                contentDescription = null,
                modifier = Modifier
                    .height(188.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(4.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                "Just Another Day For Coding" + "on the 6th day of ppkm in Pekanbaru.",
                style = typography.h5,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                "Pekanbaru, Riau",
                style = typography.body2
            )
            Text(
                "Juli, 2021",
                style = typography.body2
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewGreeting() {
    NewStory()
}