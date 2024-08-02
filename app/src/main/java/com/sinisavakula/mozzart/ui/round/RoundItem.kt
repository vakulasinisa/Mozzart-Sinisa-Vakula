package com.sinisavakula.mozzart.ui.round

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sinisavakula.mozzart.R
import com.sinisavakula.mozzart.misc.toRemainingTime
import com.sinisavakula.mozzart.misc.toSecond
import com.sinisavakula.mozzart.misc.toTime
import com.sinisavakula.mozzart.model.Round
import com.sinisavakula.mozzart.ui.theme.MozzartSinisaVakulaTheme
import kotlinx.coroutines.delay

@Composable
fun RoundItem(
    round: Round,
    onClick: () -> Unit
) {
    var remainingTime by remember { mutableStateOf(round.drawTime.toRemainingTime()) }

    LaunchedEffect(Unit) {
        while (true) {
            remainingTime = round.drawTime.toRemainingTime()
            delay(1000)
        }
    }
     val statusText = if (round.drawTime.toSecond()< 1){
         stringResource(id = R.string.draw_is_started)
     }else{
         remainingTime
     }
    Surface(
        modifier = Modifier
            .padding(5.dp)
            .clickable {
                onClick()
                       },
        shape = RoundedCornerShape(5.dp)

    ) {
        Row(
            modifier = Modifier
                .background(Color.LightGray)
                .padding(10.dp)
        ) {
            Text(
                text = round.drawTime.toTime(),
                color = Color.Black
            )
            Spacer(modifier = Modifier.weight(1F))
            Text(
                text = statusText,
                color = if (round.drawTime.toSecond() < 60) Color.Red else Color.Black
            )
        }
    }
}

@Preview
@Composable
fun RoundItemPreview() {
    MozzartSinisaVakulaTheme {
        RoundItem(
            round = Round(id = ""),
            onClick = {}
        )
    }
}