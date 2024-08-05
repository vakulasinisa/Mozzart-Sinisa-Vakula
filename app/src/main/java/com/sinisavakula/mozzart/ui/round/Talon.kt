package com.sinisavakula.mozzart.ui.round

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
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
import com.sinisavakula.mozzart.ui.common.Table
import com.sinisavakula.mozzart.ui.theme.MozzartSinisaVakulaTheme

@Composable
fun Talon(
    round: Round?,
    remainingTime: String,
    selectedNumbers: List<Int>,
    onClickNumber: (Boolean, Int) -> Unit,
    onClickRandom: () -> Unit,
    onClickPayment: () -> Unit,
) {
    Column(
        modifier = Modifier
            .background(Color.Black)
            .fillMaxSize()
            .padding(10.dp)
    ) {

        Text(
            text = stringResource(id = R.string.draw_time_info, round?.drawTime?.toTime()?:""),
            color = MaterialTheme.colorScheme.secondary
        )
        Text(
            text = stringResource(
                id = R.string.remaining_time_for_payment_info, remainingTime
            ),
            color = MaterialTheme.colorScheme.secondary
        )

        Text(
            text = stringResource(id = R.string.draw_number, round?.drawId ?: 0),
            color = MaterialTheme.colorScheme.secondary
        )
        Text(
            text = stringResource(id = R.string.odds),
            color = MaterialTheme.colorScheme.secondary
        )
        Spacer(modifier = Modifier.height(10.dp))
        Box(
            modifier = Modifier
                .border(1.dp, color = MaterialTheme.colorScheme.secondary)
                .padding(10.dp)
        ) {
            LazyRow {
                items(Odds.entries.toTypedArray()) { odd ->
                    OddItem(odd)
                }
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Table(
            numberOfRow = 8,
            numberOfColumn = 10,
            numbers = (1..80).toList(),
            selectedNumbers = selectedNumbers,
            onClickNumber = onClickNumber,
            isTalon = true
        )

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.secondary,
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