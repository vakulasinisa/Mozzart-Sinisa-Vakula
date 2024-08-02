package com.sinisavakula.mozzart.ui.round

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sinisavakula.mozzart.R
import com.sinisavakula.mozzart.misc.toTime
import com.sinisavakula.mozzart.model.Odds
import com.sinisavakula.mozzart.model.Round
import com.sinisavakula.mozzart.ui.common.AppButton
import com.sinisavakula.mozzart.ui.theme.MozzartSinisaVakulaTheme

@Composable
fun Talon(
    round: Round,
    remainingTime: String,
    selectedNumbers: List<Int>,
    onClickNumber: (Boolean, Int) -> Unit,
    onClickRandom: () -> Unit,
    onClickPayment: () -> Unit,
) {
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        Text(text = stringResource(id = R.string.draw_time_info, round.drawTime.toTime()))
        Text(
            text = stringResource(
                id = R.string.remaining_time_for_payment_info, remainingTime
            )
        )

        Text(
            text = stringResource(id = R.string.draw_number, round.drawId ?: 0)
        )
        Text(
            text = stringResource(id = R.string.odds)
        )

        Box(modifier = Modifier.border(1.dp, color = Color.Gray).padding(10.dp)){
            LazyRow{
                items(Odds.entries.toTypedArray()){odd ->
                    OddItem(odd)
                }
            }
        }
        repeat(8) { row ->
            Row {
                repeat(10) { column ->
                    val number = row * 10 + column + 1
                    NumberItem(
                        modifier = Modifier.weight(1F),
                        number = number,
                        isSelected = selectedNumbers.contains(number),
                        onClick = { isSelected, selectedNumber ->
                            onClickNumber(isSelected, selectedNumber)
                        }
                    )
                }
            }
        }

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            textAlign = TextAlign.Center,
            text = stringResource(id = R.string.selected_numbers, selectedNumbers.size)
        )
        Row(modifier = Modifier.padding(15.dp)) {
            AppButton(
                modifier = Modifier.weight(1F),
                text = stringResource(id = R.string.random_selected),
                onClick = onClickRandom
            )
            Spacer(modifier = Modifier.width(10.dp))
            AppButton(
                modifier = Modifier.weight(1F),
                text = stringResource(id = R.string.payment),
                enabled = selectedNumbers.size > 19,
                onClick = onClickPayment
            )
        }
    }
}

@Preview
@Composable
fun TalonPreview() {
    MozzartSinisaVakulaTheme {
        Talon(
            round = Round(),
            remainingTime = "",
            selectedNumbers = listOf(),
            onClickNumber = { _, _ -> },
            onClickRandom = {},
            onClickPayment = {}
        )
    }
}