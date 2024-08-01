package com.sinisavakula.mozzart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.sinisavakula.mozzart.ui.main.MainNavHost
import com.sinisavakula.mozzart.ui.theme.MozzartSinisaVakulaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MozzartSinisaVakulaTheme {
                MainNavHost()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MozzartSinisaVakulaTheme {
    }
}