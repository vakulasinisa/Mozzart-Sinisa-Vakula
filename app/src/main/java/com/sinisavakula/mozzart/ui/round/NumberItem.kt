package com.sinisavakula.mozzart.ui.round

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
fun NumberItem(
    modifier: Modifier = Modifier,
    number: Int,
    isSelected: Boolean = false,
    onClick: (Boolean, Int) -> Unit
) {

    Box(modifier = modifier) {
        Box(
            modifier = Modifier
                .size(35.dp)
                .clip(CircleShape)
                .border(
                    width = 2.dp,
                    color = if (isSelected) Color.Blue else Color.White,
                    CircleShape
                )
                .clickable { onClick(!isSelected, number) },
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
fun NumberItemPreview() {
    MozzartSinisaVakulaTheme {
        NumberItem(
            number = 1,
            onClick = {_,_ ->}
        )
    }
}

@Preview
@Composable
fun NumberItemSelectedPreview() {
    MozzartSinisaVakulaTheme {
        NumberItem(
            number = 1,
            isSelected = true,
            onClick = {_,_ ->}
        )
    }
}