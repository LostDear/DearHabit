package cn.dear.my_app

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import cn.dear.my_app.navigation.CommonNavigator
import cn.dear.my_app.navigation.NavItem
import cn.dear.my_app.screen.HomeScreen

class MainActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainApp()
        }
    }
}

@Composable
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
fun MainApp() {

    val navController: NavHostController = rememberNavController()

    Scaffold(bottomBar = {
        CommonNavigator(items = bottomBarItems) {
            navController.navigate(it.route)
        }
    }) {
        NavHost(navController = navController, startDestination = bottomBarItems.first().route) {
            bottomBarItems.forEach() { item ->
                composable(route = item.route) {
                    item.screen()
                }
            }
        }
    }

}

// TODO: Replace with real screens
val bottomBarItems = listOf(
    NavItem(icon = Icons.Rounded.Home, route = "home",screen = { HomeScreen() }),
)