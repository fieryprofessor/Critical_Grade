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
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.criticalgrade.ui.theme.CriticalGradeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CriticalGradeTheme {
              MyApp()
            }
        }
    }
}

@Composable
fun MyApp() {
    Scaffold(
        topBar = { TopBar() }
    ) {
            innerPadding ->
        MainContent( modifier = Modifier.padding(innerPadding))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    CenterAlignedTopAppBar(
        title = {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = "Critical Grade")
        }
        }
    )
}

@Composable
fun MainContent(modifier: Modifier = Modifier) {
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
            textAlign = TextAlign.Justify,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(6.dp)
        )
        Button(
            onClick = { /*TODO*/ },
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
    MyApp()
}

