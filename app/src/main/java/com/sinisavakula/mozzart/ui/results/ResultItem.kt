package com.sinisavakula.mozzart.ui.results

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sinisavakula.mozzart.R
import com.sinisavakula.mozzart.misc.toTime
import com.sinisavakula.mozzart.model.Result
import com.sinisavakula.mozzart.model.WinningNumbers
import com.sinisavakula.mozzart.ui.common.Table
import com.sinisavakula.mozzart.ui.theme.MozzartSinisaVakulaTheme

@Composable
fun ResultItem(result: Result) {
    Box(modifier = Modifier.padding(5.dp)) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .border(
                    width = 2.dp,
                    color = MaterialTheme.colorScheme.secondary,
                    shape = RoundedCornerShape(10.dp)
                )
                .background(Color.Black)
                .padding(10.dp)
        ) {
            Row {
                Text(
                    text = stringResource(id = R.string.draw_time_info, result.drawTime.toTime()),
                    color = Color.White
                )
                Spacer(modifier = Modifier.weight(1F))
                Text(
                    text = stringResource(id = R.string.draw, result.drawId),
                    color = Color.White
                )
            }
            HorizontalDivider(modifier = Modifier.padding(vertical = 10.dp), color = Color.Gray)
            Table(
                numberOfRow = 3,
                numberOfColumn = 7,
                numbers = result.winningNumbers.list,
                isTalon = false
            )
        }
    }
}

@Preview
@Composable
fun ResultItemPreview() {
    MozzartSinisaVakulaTheme {
        ResultItem(
            result = Result(
                gameId = 0,
                drawId = 0,
                drawTime = 0,
                status = "",
                winningNumbers = WinningNumbers((1..20).toList())
            )
        )
    }
}