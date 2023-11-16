package com.example.firstcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.firstcompose.screens.CategoryScreen
import com.example.firstcompose.screens.DetailScreen
import com.example.firstcompose.ui.theme.FirstComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstComposeTheme {
                MyNavGraph()
            }
        }
    }

    @Composable
    fun MyNavGraph() {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = "category", builder = {
            composable(route = "category",
                content = {
                    CategoryScreen(onClick = { category: String ->
                        navController.navigate(route = "detail/$category")
                    })
                })

            composable(route = "detail/{category}",
                arguments = listOf(
                    navArgument(name = "category", builder = {
                        type = NavType.StringType
                    })
                ),
                content = {
                    DetailScreen()
                })
        })
    }
}
