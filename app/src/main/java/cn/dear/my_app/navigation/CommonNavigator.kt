package cn.dear.my_app.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun CommonNavigator(
    items: List<NavItem>,
    currentRoute: String? = null,
    startIndex: Int = 0,
    onItemSelected: (NavItem) -> Unit,
) {
    if (items.isEmpty()) throw IllegalArgumentException("BottomBar items cannot be empty")
    if (items.size>5) throw IllegalArgumentException("BottomBar items cannot be more than 5")
    var selectedIndex: Int by remember {
        mutableIntStateOf(startIndex)
    }
    if (currentRoute != null) {
        selectedIndex = items.indexOfFirst { it.route == currentRoute }
    }

    BottomAppBar(modifier = Modifier) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            items.forEachIndexed { index, item ->
                IconButton(
                    modifier = Modifier.weight(1f),
                    onClick = {
                        onItemSelected(item)
                        selectedIndex = index
                    }) {
                    val isSelected = selectedIndex == index
                    val color = if (isSelected) item.checkedColor else item.uncheckedColor
                    Icon(item.icon, contentDescription = item.label, tint = color)
                }
            }
        }
    }

}