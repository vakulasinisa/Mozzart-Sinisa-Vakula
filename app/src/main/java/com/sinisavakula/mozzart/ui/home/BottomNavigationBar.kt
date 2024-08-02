package com.sinisavakula.mozzart.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.sinisavakula.mozzart.R

@Composable
fun BottomNavigationBar(selectedIndex: Int, onItemSelected: (Int) -> Unit) {
    Row(modifier = Modifier.fillMaxWidth().background(MaterialTheme.colorScheme.primary)) {
        BottomNavigationItem(
            modifier = Modifier.weight(1F),
            title = stringResource(id = R.string.games),
            drawable = R.drawable.ic_home,
            onClick ={if (selectedIndex != 0) onItemSelected(0)},
            isSelected = selectedIndex == 0
        )
        BottomNavigationItem(
            modifier = Modifier.weight(1F),
            title = stringResource(id = R.string.results),
            drawable = R.drawable.ic_results,
            onClick ={if (selectedIndex != 1) onItemSelected(1)},
            isSelected = selectedIndex == 1
        )
    }
}