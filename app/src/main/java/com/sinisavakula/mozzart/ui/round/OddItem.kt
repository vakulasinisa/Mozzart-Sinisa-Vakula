package com.sinisavakula.mozzart.ui.round

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.sinisavakula.mozzart.model.Odds

@Composable
fun OddItem (
    odd: Odds
){
    Row {
        Column(
            modifier = Modifier.padding(5.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = odd.number.toString())
            Text(text = odd.odds.toLong().toString())
        }
        HorizontalDivider(color = Color.Gray)
    }
}