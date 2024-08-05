package com.sinisavakula.mozzart.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sinisavakula.mozzart.ui.theme.MozzartSinisaVakulaTheme

@Composable
fun AppButton(
    modifier: Modifier = Modifier,
    text: String,
    enabled: Boolean = true,
    onClick: () -> Unit,
) = Surface(
    shape = RoundedCornerShape(8.dp),
    color = Color.Transparent,
    modifier = modifier
        .height(48.dp)
        .fillMaxWidth()
) {
    val focusManager = LocalFocusManager.current
    Box(
        modifier = Modifier
            .background(color = if (enabled) MaterialTheme.colorScheme.primary else Color.Gray)
            .run {
                if (enabled) {
                    clickable {
                        focusManager.clearFocus(true)
                        onClick()
                    }
                } else {
                    pointerInput(Unit) {
                        detectTapGestures {
                            focusManager.clearFocus(true)
                        }
                    }
                }
            },
        contentAlignment = Alignment.Center,
    ) {

        Text(
            text = text,
            color = if (enabled) MaterialTheme.colorScheme.secondary else Color.White,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .width(intrinsicSize = IntrinsicSize.Max)
                .padding(horizontal = 16.dp)
        )
    }
}

@Preview
@Composable
fun AppButtonPreview() {
    MozzartSinisaVakulaTheme {
        AppButton(
            text = "Enabled",
            onClick = {}
        )
    }
}

@Preview
@Composable
fun AppButtonSurfacePreview() {
    MozzartSinisaVakulaTheme {
        AppButton(
            text = "Disable",
            enabled = false,
            onClick = {},
        )
    }
}