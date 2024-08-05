package com.sinisavakula.mozzart.ui.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.sinisavakula.mozzart.R

@Composable
fun AppDialog (
    title: Int = R.string.success_title,
    buttonText: Int = R.string.ok,
    onClickButton: () -> Unit

){
    Dialog(
        onDismissRequest = onClickButton,
    ) {
        Surface(
            shape = RoundedCornerShape( 24.dp),
            color = MaterialTheme.colorScheme.surface,
        ) {
            Column(
                modifier = Modifier.padding(50.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = stringResource(id = title),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(horizontal = 30.dp)
                )
                Spacer(modifier = Modifier.height(30.dp))
                AppButton(
                    text = stringResource(id = buttonText),
                    onClick = onClickButton,
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 40.dp)
                )
            }
        }
    }
}