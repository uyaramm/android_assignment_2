package com.example.assignment2_uyaramontovaneli


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.assignment2_uyaramontovaneli.ui.theme.Assignment2_uyaramontovaneliTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Assignment2_uyaramontovaneliTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    //color = MaterialTheme.colorScheme.background
                    color = Color(0xBFE0E0E0)
                ) {
                    Main()
                }
            }
        }
    }
}

@Composable
fun Main() {
    var index by remember { mutableStateOf(1) }
    val maxIndex = 3

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 20.dp)
    ) {
            ImageFlow(index)
            TextFlow(index)

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .fillMaxHeight(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Bottom
        ) {
            Button(
                onClick = {
                    index = if (index > 1) {
                        index - 1
                    } else {
                        maxIndex
                    }
                },
                modifier = Modifier.padding(8.dp)
            ) {
                Text("Previous")
            }

            Button(
                onClick = {
                    index = if (index < maxIndex) {
                        index + 1
                    } else {
                        1
                    }
                },
                modifier = Modifier.padding(8.dp)
            ) {
                Text("Next")
            }
        }
    }
}

@Composable
fun ImageFlow(image: Int) {
    val painter = painterResource(id = when (image) {
        1 -> R.drawable.refugiees
        2 -> R.drawable.annefrank
        3 -> R.drawable.coronavirus
        else -> throw IllegalArgumentException("Invalid image index: $image")
    })

    Box(
        modifier = Modifier
            .size(400.dp)
            .fillMaxHeight()
            .padding(16.dp)
            .border(4.dp, Color(0x8087CEEB), shape = RoundedCornerShape(8.dp))
            .shadow(8.dp, shape = RoundedCornerShape(8.dp)),

    ) {
        Image(
            painter = painter,
            contentDescription = null,
            modifier = Modifier
                .size(300.dp)
                .align(Alignment.Center)
        )
    }
}


@Composable
fun TextFlow(content: Int) {
    // title
    val title = when (content) {
        1 -> R.string.title_first_image
        2 -> R.string.title_second_image
        3 -> R.string.title_third_image
        else -> throw IllegalArgumentException("Invalid content: $content")
    }

    // text string
    val text = when (content) {
        1 -> R.string.first_image
        2 -> R.string.second_image
        3 -> R.string.third_image
        else -> throw IllegalArgumentException("Invalid content: $content")
    }

    // text and title column
    Column(
        modifier = Modifier
            .padding(horizontal = 30.dp, vertical = 50.dp)
            .background(  Color(0x7087CEEB) , shape = RoundedCornerShape(5.dp))
            .fillMaxWidth(),
    ) {
        // title
        Text(
            text = stringResource(id = title),
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp)
        )

        // text
        Text(
            text = stringResource(id = text),
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 16.dp)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Assignment2_uyaramontovaneliTheme {
        Main();
    }
}