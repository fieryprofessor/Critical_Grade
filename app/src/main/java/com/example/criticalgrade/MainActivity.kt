package com.example.criticalgrade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.criticalgrade.ui.theme.AppTheme
import com.example.criticalgrade.ui.theme.DarkYellow
import com.example.criticalgrade.ui.theme.Indigo
import com.example.criticalgrade.ui.theme.Orange
import com.example.criticalgrade.ui.theme.Violet

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Surface(color = MaterialTheme.colorScheme.surface) {
                AppTheme {
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun MyApp() {
    val navController =rememberNavController()
    NavHost(navController = navController , startDestination = "mainscreen"){
        composable(route = "mainscreen"){
            Scaffold(
                topBar = { TopBar() }
            ) {
                    innerPadding ->
                MainContent( navController, modifier = Modifier.padding(innerPadding))
            }
        }
        composable(route = "calculatorscreen"){
            Calculator(navController)
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    CenterAlignedTopAppBar(
        title = {
        Row(verticalAlignment = Alignment.CenterVertically) {
            AppBarText()
            }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(MaterialTheme.colorScheme.outlineVariant),
    )
}

@Composable
fun AppBarText() {
    Text(
        text = "Critical Grade",
        fontSize = 30.sp,
        fontWeight = FontWeight.ExtraBold
    )
}

@Composable
fun MainContent(navController: NavController, modifier: Modifier = Modifier) {
    val gradientColors = listOf(Red, Orange, DarkYellow, Green, Blue, Indigo, Violet)
    Column(
        modifier
            .fillMaxSize()
            .border(4.dp, Color.Black),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Easily calculate and manage your Cumulative Grade Point Average with our" +
                " user-friendly app. Track your academic progress, set goals, and stay on top of " +
                "your studies effortlessly. Let's get started on your path to academic success!",
            textAlign = TextAlign.Center,
            style = TextStyle(brush = Brush.linearGradient(colors = gradientColors)),
            letterSpacing = 5.sp,
            lineHeight = 40.sp,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(6.dp)
        )
        Button(
            onClick = { navController.navigate("calculatorscreen") },
            colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.tertiary),
            modifier = Modifier
                .padding(top = 15.dp, start = 8.dp, end = 8.dp)
                .fillMaxWidth()
        ) {
            Text(text = "Lets Get Started")
        }
    }
}

@Preview(showSystemUi = true , name = "My Preview")
@Composable
fun AppPreview(){
    AppTheme {
        MyApp()
    }
}

