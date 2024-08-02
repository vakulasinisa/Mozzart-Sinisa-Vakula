package com.sinisavakula.mozzart.ui.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun BottomNavigationItem(
    modifier: Modifier = Modifier,
    title: String,
    drawable: Int,
    onClick: () -> Unit,
    isSelected: Boolean
) {
    val contentColor = if (isSelected) {
        MaterialTheme.colorScheme.secondary
    } else {
        Color.Gray
    }
    Column(
        modifier = modifier
            .clickable { onClick() }
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            modifier = Modifier.size(35.dp),
            painter = painterResource(id = drawable),
            contentDescription = null,
            tint = contentColor
        )
        Text(
            text = title,
            color = contentColor
        )
    }
}