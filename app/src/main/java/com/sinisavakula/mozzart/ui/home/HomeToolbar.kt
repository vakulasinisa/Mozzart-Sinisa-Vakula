package com.sinisavakula.mozzart.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sinisavakula.mozzart.R
import com.sinisavakula.mozzart.ui.theme.MozzartSinisaVakulaTheme

@Composable
fun HomeToolbar(){
    Column(modifier = Modifier.background(Color.LightGray)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(75.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier.padding(10.dp),
                painter = painterResource(id = R.drawable.greece_flag),
                contentDescription = null
            )
            Text(
                text = stringResource(id = R.string.greece_lotto),
                fontSize = 20.sp
            )

        }
        HorizontalDivider(color = Color.Gray)
        Row(modifier = Modifier.fillMaxWidth().padding(5.dp)) {
            Text(text = stringResource(id = R.string.draw_time))
            Spacer(modifier = Modifier.weight(1F))
            Text(text = stringResource(id = R.string.remaining_time_for_payment))
        }
    }
}

@Preview
@Composable
fun HomeToolbarPreview(){
    MozzartSinisaVakulaTheme {
        HomeToolbar()
    }
}