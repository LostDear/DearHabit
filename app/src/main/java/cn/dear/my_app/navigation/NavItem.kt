package cn.dear.my_app.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

data class NavItem(
    val icon: ImageVector,
    val label: String? = "",
    val route: String,
    val checkedColor: Color = Color.Blue,
    val uncheckedColor: Color = Color.Gray,
    val screen: @Composable () -> Unit
)
