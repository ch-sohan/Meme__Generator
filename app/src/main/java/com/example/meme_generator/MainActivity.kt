package com.example.meme_generator

import android.os.Bundle
import android.content.Context
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.meme_generator.ui.theme.Meme_GeneratorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Meme_GeneratorTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var templateName by remember { mutableStateOf(TextFieldValue()) }
    var topText by remember { mutableStateOf(TextFieldValue()) }
    var bottomText by remember { mutableStateOf(TextFieldValue()) }
    var imageUrl by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Txt("Template Name")
        Tf("Enter template name", templateName) { templateName = it }
        Txt("Top text")
        Tf("Enter top text", topText) { topText = it }
        Txt("Bottom text")
        Tf("Enter bottom text", bottomText) { bottomText = it }
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = {
                //Toast.makeText(MainActivity.this,"Button Clicked",Toast.LENGTH_SHORT).show()
                imageUrl = generateMeme(templateName.text, topText.text, bottomText.text)
            },
            modifier = modifier.width(300.dp)
                .height(55.dp)
                .padding(horizontal = 50.dp)
        ) {
            Text("Generate Meme", fontSize = 20.sp)
        }

        imageUrl?.let { url ->
            AsyncImage(
                model =imageUrl,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(all = 15.dp)
                    .align(Alignment.CenterHorizontally)
            )

        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Meme_GeneratorTheme {
        Greeting("Android")
    }
}

fun generateMeme(template: String, topText: String, bottomText: String): String {
    return "https://apimeme.com/meme?meme="+template+"&top="+topText+"&bottom="+bottomText
}

@Composable
fun Txt(name: String) {
    Text(
        text = "$name",
        color = Color.Black,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily.Default,
        modifier = Modifier.padding(bottom = 8.dp)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Tf(name: String, value: TextFieldValue, onValueChanged: (TextFieldValue) -> Unit) {
    TextField(
        value = value,
        onValueChange = { newValue -> onValueChanged(newValue) },
        label = { Text("$name") },
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 1.dp, top = 1.dp)
    )
}
