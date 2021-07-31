package com.amaliasrasyid.learn_jetpack_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.amaliasrasyid.learn_jetpack_compose.ui.theme.LearnJetpackcomposeTheme

class BasicComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                MyScreeContent(List(1000) { "Hello android $it" })
            }
        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    LearnJetpackcomposeTheme {
        Surface(color = MaterialTheme.colors.background) {
            content()
        }
    }
}

@Composable
fun Counter(count: Int, updateCount: (Int) -> Unit) {
    Button(onClick = { updateCount(count + 1) }) {
        Text("I've been clicked $count times")
    }
}

@Composable
fun MyScreeContent(names: List<String>) {
    Surface(color = MaterialTheme.colors.background) {
        var counterState by remember { mutableStateOf(0) }

        Column(modifier = Modifier.fillMaxHeight()) {
            NamesList(names = names, modifier = Modifier.weight(1f))
            Counter(
                count = counterState,
                updateCount = { newCount ->
                    counterState = newCount
                }
            )
            if (counterState > 7) {
                Text(text = "I Love to count!")
            }
        }
    }
}

@Composable
fun NamesList(names: List<String>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(items = names) {
            for (name in names) {
                Greeting(name = it)
                Divider()
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    var isSelected by remember {
        mutableStateOf(false)
    }
    val targetColor by animateColorAsState(
        targetValue = if (isSelected) MaterialTheme.colors.primary else Color.Transparent,
        animationSpec = tween(durationMillis = 400)
    )
    Surface(color = targetColor) {
        Text(
            text = "Hello $name!",
            Modifier
                .padding(16.dp)
                .clickable { isSelected = !isSelected }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp {
        MyScreeContent(listOf("Amalia S. Rasyid", "Android2"))
    }
}