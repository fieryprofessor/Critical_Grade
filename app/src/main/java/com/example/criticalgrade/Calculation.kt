package com.example.criticalgrade



import android.annotation.SuppressLint
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


@Composable
fun Calculator(navController: NavController) {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(2.dp)
            .border(4.dp, Color.Black)
            .verticalScroll(rememberScrollState())
    ) {
        Subjects(navController)
    }
}

@Composable
fun Subjects(navController: NavController) {
    Text(
        text = "Select the number of subjects in the semester: ",
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        modifier = Modifier
            .padding(10.dp)
    )
    Spacer(modifier = Modifier.height(16.dp))
    var i by rememberSaveable{ mutableIntStateOf(0) }

    var grade1 by rememberSaveable{ mutableStateOf("") }
    var credit1 by rememberSaveable{ mutableIntStateOf(0) }
    var grade2 by rememberSaveable{ mutableStateOf("") }
    var credit2 by rememberSaveable{ mutableIntStateOf(0) }
    var grade3 by rememberSaveable{ mutableStateOf("") }
    var credit3 by rememberSaveable{ mutableIntStateOf(0) }
    var grade4 by rememberSaveable{ mutableStateOf("") }
    var credit4 by rememberSaveable{ mutableIntStateOf(0) }
    var grade5 by rememberSaveable{ mutableStateOf("") }
    var credit5 by rememberSaveable{ mutableIntStateOf(0) }
    var grade6 by rememberSaveable{ mutableStateOf("") }
    var credit6 by rememberSaveable{ mutableIntStateOf(0) }
    var grade7 by rememberSaveable{ mutableStateOf("") }
    var credit7 by rememberSaveable{ mutableIntStateOf(0) }
    var grade8 by rememberSaveable{ mutableStateOf("") }
    var credit8 by rememberSaveable{ mutableIntStateOf(0) }
    var sgpa by rememberSaveable { mutableDoubleStateOf(0.0) }
    var showsgpa by rememberSaveable { mutableStateOf(false) }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {

        Button(
            onClick = { i=4 },
            modifier = Modifier.padding(start = 2.dp , end = 2.dp)
        ) {
            Text(text = "4")
        }
        Button(
            onClick = { i=5 },
            modifier = Modifier.padding(start = 2.dp , end = 2.dp)
        ) {
            Text(text = "5")
        }
        Button(
            onClick = { i=6 },
            modifier = Modifier.padding(start = 2.dp , end = 2.dp)
        ) {
            Text(text = "6")
        }
        Button(
            onClick = { i=7 },
            modifier = Modifier.padding(start = 2.dp , end = 2.dp)
        ) {
            Text(text = "7")
        }
        Button(
            onClick = { i=8 },
            modifier = Modifier.padding(start = 2.dp , end = 2.dp)
        ) {
            Text(text = "8")
        }
    }
    Spacer(modifier = Modifier.height(16.dp))
    Text(text = "Subjects selected: $i",fontSize = 20.sp)
    Spacer(modifier = Modifier.height(32.dp))

    for(x in 1..i){

        SubjectName(value = x)
        Spacer8dp()
        when(x){
            1->{ GradeTextField(grade1){grade1 = it}
                Spacer8dp()
                CreditTextField(credit1){credit1 = it}
                Spacer8dp()
            }
            2->{ GradeTextField(grade2){grade2 = it}
                Spacer8dp()
                CreditTextField(credit2){credit2 = it}
                Spacer8dp()
            }
            3->{ GradeTextField(grade3){grade3 = it}
                Spacer8dp()
                CreditTextField(credit3){credit3 = it}
                Spacer8dp()
            }
            4->{ GradeTextField(grade4){grade4 = it}
                Spacer8dp()
                CreditTextField(credit4){credit4 = it}
                Spacer8dp()
            }
            5->{ GradeTextField(grade5){grade5 = it}
                Spacer8dp()
                CreditTextField(credit5){credit5 = it}
                Spacer8dp()
            }
            6->{ GradeTextField(grade6){grade6 = it}
                Spacer8dp()
                CreditTextField(credit6){credit6 = it}
                Spacer8dp()
            }
            7->{ GradeTextField(grade7){grade7 = it}
                Spacer8dp()
                CreditTextField(credit7){credit7 = it}
                Spacer8dp()
            }
            8->{ GradeTextField(grade8){grade8 = it}
                Spacer8dp()
                CreditTextField(credit8){credit8 = it}
                Spacer8dp()
            }

        }
    }

    Spacer(modifier = Modifier.height(20.dp))
    Button(
        onClick = {
            val totalCredits = credit1 +credit2+credit3+credit4+ credit5+credit6+credit7+credit8
            val totalGradepoints:Double = calGrade(grade1,credit1)+calGrade(grade2,credit2)+calGrade(grade3,credit3)+calGrade(grade4,credit4)+calGrade(grade5,credit5)+calGrade(grade6,credit6)+calGrade(grade7,credit7)+calGrade(grade8,credit8)
            sgpa = if(totalCredits>0){
                totalGradepoints/totalCredits.toDouble()
            } else{
                0.0
            }
            showsgpa = true
        },
        colors = ButtonDefaults.buttonColors(Color(0xFFBEABE0))
    ) {
        Text(text = "Calculate SGPA", color = Color.Black)
    }
    Spacer(modifier = Modifier.height(20.dp))
    val rounded = Math.round(sgpa*100)
    val answer = rounded/100.0
   FinalShower(key = showsgpa, answer = answer )
    Spacer(modifier = Modifier.height(20.dp))
    Button(onClick = { navController.popBackStack("mainscreen",false) }) {
        Text(text = "Back to Home Screen")
    }
    Spacer(modifier = Modifier.height(32.dp))
}


fun calGrade(grade:String, credit:Int):Double{
  var result = when(grade.uppercase()){
        "O" -> 10.0
        "A" -> 9.5
        "B" -> 8.5
        "C" -> 7.5
        "D" -> 6.5
        "E" -> 5.5
        else -> 0.0
    }
    result *= credit
    return result
}

@Composable
fun Spacer8dp() {
    Spacer(modifier = Modifier.padding(top=8.dp))
}

@Composable
fun SubjectName(value:Int) {
    Text(
        text = "Subject $value",
        fontSize = 15.sp,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun FinalShower(key:Boolean,answer:Double) {
    if(key){
        Text(
            text = "Your SGPA is : $answer",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    }
}


@Composable
fun GradeTextField(grade:String, onValueChange :(String)->Unit) {
    val containerColor = Color(0xFF7E57C2)
    TextField(
        value = grade,
        onValueChange = {text->onValueChange(text)},
        label = { Text(text = "Enter Grade",color = Color.Magenta, fontSize = 10.sp)},
        colors = TextFieldDefaults.colors(
            focusedContainerColor = containerColor,
            unfocusedContainerColor = containerColor,
            disabledContainerColor = containerColor,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
        ),
        shape = RoundedCornerShape(20.dp),
        textStyle = TextStyle(fontSize = 12.sp, color = Color.White),
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(start = 6.dp, end = 6.dp)
    )
}

@SuppressLint("InvalidColorHexValue")
@Composable
fun CreditTextField(credit:Int?, onValueChange :(Int)->Unit) {
    val containerColor = Color(0xFF7D8CCED)
    TextField(
        value = credit.toString(),
        onValueChange = {text->onValueChange(text.toInt())},
        label = { Text(text = "Enter Credit",color = Color.Magenta, fontSize = 10.sp)},
        colors = TextFieldDefaults.colors(
            focusedContainerColor = containerColor,
            unfocusedContainerColor = containerColor,
            disabledContainerColor = containerColor,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
        ),
        shape = RoundedCornerShape(20.dp),
        textStyle = TextStyle(fontSize = 12.sp, color = Color.White),
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(start = 6.dp, end = 6.dp)
    )
}


@SuppressLint("SuspiciousIndentation")
@Preview(showSystemUi = true , name = "CGPA Cal")
@Composable
private fun CalculatorPreview() {
    val navController = rememberNavController()
        Calculator(navController)
}
