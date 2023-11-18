package com.example.firstcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.firstcompose.screens.CategoryScreen
import com.example.firstcompose.screens.DetailScreen
import com.example.firstcompose.ui.theme.FirstComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@OptIn(ExperimentalMaterial3Api::class)
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstComposeTheme {
                Scaffold(
                    topBar = {
                        CenterAlignedTopAppBar(
                            title = {
                                Text(text = "Tweetsy")
                            },
                            colors = TopAppBarDefaults.smallTopAppBarColors(
                                titleContentColor = Color.Red,
                                containerColor = Color.Black
                            )
                        )
                    }
                ) {
                    Box(modifier = Modifier.padding(it)) {
                        MyNavGraph()
                    }
                }
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
