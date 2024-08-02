package com.sinisavakula.mozzart.ui.results

import android.util.Log
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
import androidx.compose.ui.unit.dp
import com.sinisavakula.mozzart.R
import com.sinisavakula.mozzart.misc.toTime
import com.sinisavakula.mozzart.model.Result

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
                .padding(10.dp)
        ) {
            Row {
                Text(text = stringResource(id = R.string.draw_time_info, result.drawTime.toTime()))
                Spacer(modifier = Modifier.weight(1F))
                Text(
                    text = stringResource(id = R.string.draw, result.drawId)
                )
            }
            HorizontalDivider(modifier = Modifier.padding(vertical = 10.dp), color = Color.Gray)
            repeat(3) { row ->
                Row (modifier = Modifier.padding(5.dp)){
                    Log.d("TestNumbers", "time: " +row)
                    repeat(7) { column ->
                        val number = row * 7 + column
                        Log.d("TestNumbers", "number: " + number + " wining: " + result.winningNumbers.list.size)
                        if (number < 20) {
                            ResultNumberItem(
                                modifier = Modifier.weight(1F),
                                number = result.winningNumbers.list[number],
                            )
                        }
                    }
                }
            }
        }
    }
}