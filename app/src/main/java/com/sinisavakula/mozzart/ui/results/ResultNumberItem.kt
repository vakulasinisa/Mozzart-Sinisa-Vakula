package com.sinisavakula.mozzart.ui.results

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sinisavakula.mozzart.ui.theme.MozzartSinisaVakulaTheme

@Composable
fun ResultNumberItem(
    modifier: Modifier = Modifier,
    number: Int,
) {

    Box(modifier = modifier) {
        Box(
            modifier = Modifier
                .size(45.dp)
                .clip(CircleShape)
                .border(
                    width = 2.dp,
                    color = Color.Blue,
                    CircleShape
                ),
            contentAlignment = Alignment.Center,

            ) {
            Text(
                text = number.toString(),
            )
        }
    }
}

@Preview
@Composable
fun ResultNumberItemPreview() {
    MozzartSinisaVakulaTheme {
        ResultNumberItem(
            number = 1,
        )
    }
}