package com.example.meme_generator

import android.os.Bundle
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.meme_generator.ui.theme.Meme_GeneratorTheme

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Meme_GeneratorTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting2("Android")
                }
            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier) {
    var context= LocalContext.current
    var username by remember { mutableStateOf(TextFieldValue()) }
    var password by remember { mutableStateOf(TextFieldValue()) }
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.LightGray)
            .padding(all=10.dp)

    ) {
        Text(
            text = "Welcome.",
            color = Color.Black,
            fontSize = 60.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Default,
        )

        Spacer(modifier = Modifier.height(225.dp)) // Add a vertical gap

        Txt("User Name")
        Tf("Enter Username",username){username=it}
        Txt("Password")
        Tf("Enter Password",password){password=it}

        Spacer(modifier = Modifier.height(200.dp))
        Button(
            onClick = {
                if(username.text=="User"&&password.text=="abcd"){
                    val intent= Intent(context,MainActivity::class.java)
                    context.startActivity(intent)
                }else {
                    Toast.makeText(context, "Invalid credentials", Toast.LENGTH_SHORT).show()
                }
            },
            modifier=modifier.fillMaxWidth()
                .height(55.dp)
        )
        {
            Text("Login",fontSize=20.sp)

        }

    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    Meme_GeneratorTheme {
        Greeting2("Android")
    }
}

