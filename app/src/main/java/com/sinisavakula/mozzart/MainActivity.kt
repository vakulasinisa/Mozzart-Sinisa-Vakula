package com.sinisavakula.mozzart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent cier
import androidx.compose.ui.tooling.preview.Preview
import com.sinisavakula.mozzart.ui.theme.MozzartSinisaVakulaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MozzartSinisaVakulaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MozzartSinisaVakulaTheme {
        Greeting("Android")
    }
}