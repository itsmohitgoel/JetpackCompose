package com.example.firstcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.firstcompose.screens.DetailScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyNavGraph()
        }
    }
}

@Composable
fun MyNavGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "registration", builder = {
        composable(route = "registration", content = {
            RegistrationScreen(onClick = {emailParam ->
                navController.navigate("main/$emailParam")
            })
        })

        composable(route = "login", content = {
            LoginScreen()
        })

        composable(route = "main/{emailParam}", arguments = listOf(
                navArgument(name = "emailParam", builder = { type = NavType.StringType })
            ), content = {
                val email = it.arguments!!.getString("emailParam")
                MainScreen(email!!)
            })
    })
}


/*————————————————————————————*/
@Composable
fun RegistrationScreen(onClick: (email : String) -> Unit) {
    Text(text = "Registration", style = MaterialTheme.typography.headlineLarge,
        modifier = Modifier.clickable {
            onClick("itsmohitgoel@gmail.com")
        })
}

@Composable
fun LoginScreen() {
    Text(text = "Login", style = MaterialTheme.typography.headlineLarge)
}

@Composable
fun MainScreen(email : String) {
    Text(text = "Main Screen | " + email, style = MaterialTheme.typography.headlineLarge)
}