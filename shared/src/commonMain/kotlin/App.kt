@file:OptIn(ExperimentalMaterialApi::class, ExperimentalMaterialApi::class)
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFrom
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.width
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Button
import androidx.compose.material.DrawerValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.rememberDrawerState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.sourceInformation
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import ui.theme.AppTheme
import kotlin.math.absoluteValue


fun greeting(name: String, age: String): String {
    val message = "Hello $name, you are now $age old"
    var nums = IntArray(4, {it})
    for (num in nums){
        println(num)
    }



    var list = listOf('a','b','c')
    println("list size: " + list.size)
    //list.add

    println("LIST")
    var emptyList: List<Int> = emptyList()
    println(emptyList)
    //list.add

    val otherList = mutableListOf(1,2,3,4)
    otherList.add(5)
    otherList.remove(3)
    println(otherList)

    for (chars in 'a'..'e'){
        println(chars)
    }

    lambdaTest("Hello")

    MyClass("World").myFunc()
    var myChild = MyChildClass("Hello", "World")
    myChild.myFunc()

    val person = Person()
    val dog = Dog(person)
    val cat = Cat(person)
    println(person.pets)
//    for (pet in person.pets){
//        println(pet)
//    }
    var song1 = Song("Ayaya", "dsfs", "1991", 21)
    println(song1)


    //val map = mutableMapOf()
    //val set = mutableSetOf()
    return message
}

data class Song(var title: String?, var artist: String?, var year: String?, var playCount: Int?)

fun ticketPrice(age: Int, isMonday: Boolean): Int {
    var payment = 0
    //int payment=0
    if (isMonday) {
        if(age<13){
            payment = 15
        }
        else if (age>12 || age<61){
            payment = 25
        }
        else if (age>60 || age<101){
            payment = 20
        }
        else{
            payment = -1
        }
    }
    return payment
}

class Person(val pets: MutableList<Pet> = mutableListOf())
open class Pet{
    constructor(owner: Person){
        owner.pets.add(this)
    }
}
class Cat(owner: Person) : Pet(owner)
class Dog(owner: Person) :Pet(owner)

val lambdaTest = {name:String -> println(name)}

open class MyClass(var value:String){
    //val word:String = value
    open fun myFunc(){
        println(value)
    }
}

class MyChildClass(var childValue: String, var otherValue: String) : MyClass(childValue) {
    override fun myFunc() {
        //super.myFunc()
        println(childValue + otherValue)
    }
}

fun myFunction(x: Int, y: Int) = x + y
@Composable
fun Banner(name: String) {
    Text("Hello $name")

    /*Row (modifier = Modifier.padding(24.dp).fillMaxWidth().border(BorderStroke(1.dp, Color.Black)), verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center){
        Column {
//        Text("Welcome to my App")
//        Spacer(modifier = Modifier.height(20.dp))

            Row { Text("1")}
            Row { Text("1")}
            Row { Text("1")}
            Row { Text("1")}
            Row { Text("1")}
            Row { Text("1")}
            Row { Text("1")}
        }
        Spacer(modifier = Modifier.height(20.dp).width(10.dp))
        Column {
//        Text("Welcome to my App")
//        Spacer(modifier = Modifier.height(20.dp))
//        Text("Hello $name")
            Row { Text("2")}
            Row { Text("2")}
            Row { Text("2")}
            Row { Text("2")}
            Row { Text("2")}
            Row { Text("2")}
            Row { Text("2")}
        }
        Spacer(modifier = Modifier.height(20.dp).width(10.dp))
        Column {
//        Text("Welcome to my App")
//        Spacer(modifier = Modifier.height(20.dp))
//        Text("Hello $name")
            Row { Text("3")}
            Row { Text("3")}
            Row { Text("3")}
            Row { Text("3")}
            Row { Text("3")}
            Row { Text("3")}
            Row { Text("3")}
        }
    }*/

}


@OptIn(ExperimentalResourceApi::class)
@Composable
fun ComposeArticle() {
    Column {
        Image(
            painterResource("bg_compose_background.png"), null
        )
        Text("Jetpack Compose tutorial", modifier = Modifier.padding(16.dp), fontSize = 24.sp)
        Text("Jetpack Compose is a modern toolkit for building native Android UI. Compose simplifies and accelerates UI development on Android with less code, powerful tools, and intuitive Kotlin APIs.",
            modifier = Modifier.padding(start = 16.dp, end = 16.dp), textAlign = TextAlign.Justify)
        Text("In this tutorial, you build a simple UI component with declarative functions. You call Compose functions to say what elements you want and the Compose compiler does the rest. Compose is built around Composable functions. " +
                "These functions let you define your app\\'s UI programmatically because they let you describe how it should look and provide data dependencies, rather than focus on the process of the UI\\'s construction, such as initializing an element and then attaching it to a parent. " +
                "To create a Composable function, you add the @Composable annotation to the function name.",
            modifier = Modifier.padding(16.dp), textAlign = TextAlign.Justify)
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
fun TaskManager() {
    Column (modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
        Image(
            painterResource("ic_task_completed.png"), null
        )
        Text("All tasks completed", modifier = Modifier.paddingFromBaseline(top = 24.dp, bottom = 8.dp), fontWeight = FontWeight.Bold)
        Text("Nice work!", fontSize = 16.sp)
    }
}

@Composable
fun ComposeQuadrant() {
    Column (modifier = Modifier.fillMaxSize()){
        Row (modifier = Modifier.fillMaxWidth().weight(1f)){
            Column (modifier = Modifier.background(Color(0xFFEADDFF)).weight(1f).padding(16.dp).fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
                Text("Text composable", fontWeight = FontWeight.Bold, modifier = Modifier.paddingFromBaseline(bottom = 16.dp))
                Text("Displays text and follows the recommended Material Design guidelines.", textAlign = TextAlign.Justify)}
            Column (modifier = Modifier.background(Color(0xFFD0BCFF)).weight(1f).padding(16.dp).fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
                Text("Image composable", fontWeight = FontWeight.Bold, modifier = Modifier.paddingFromBaseline(bottom = 16.dp))
                Text("Creates a composable that lays out and draws a given Painter class object.", textAlign = TextAlign.Justify)}
        }
        Row (modifier = Modifier.weight(1f)){
            Column(modifier = Modifier.background(Color(0xFFB69DF8)).weight(1f).padding(16.dp).fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                Text("Row composable", fontWeight = FontWeight.Bold, modifier = Modifier.paddingFromBaseline(bottom = 16.dp))
                Text("A layout composable that places its children in a horizontal sequence.", textAlign = TextAlign.Justify)}
            Column(modifier = Modifier.background(Color(0xFFF6EDFF)).weight(1f).padding(16.dp).fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                Text("Column composable", fontWeight = FontWeight.Bold, modifier = Modifier.paddingFromBaseline(bottom = 16.dp))
                Text("A layout composable that places its children in a vertical sequence.", textAlign = TextAlign.Justify)}
        }

    }
}

@Composable
fun TopBar(onMenuClicked: () -> Unit) {
    TopAppBar(
        title = {
            Text(text = "My App", color = Color.White)
        },
        navigationIcon = {
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = "Menu",

                modifier = Modifier.clickable (onClick = onMenuClicked),
                tint = Color.White
            )
        },
        backgroundColor = Color(0xFF0F9D58)
    )
}

@Composable
fun BottomBar() {

    BottomAppBar(
        backgroundColor = Color(0xFF0F9D58)

    ) {
        Text(text = "Bottom App Bar", color = Color.White)
        Icon(Icons.Filled.Call, contentDescription = "any")
    }
}

@Composable
fun Drawer() {

    Column(
        Modifier
            .background(Color.White)
            .fillMaxSize()
    ) {
        repeat(5) { item ->
            Text(text = "Item number $item", modifier = Modifier.padding(8.dp), color = Color.Black)
        }
    }
}

@Composable
fun Body() {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        //Banner("Justin")
        //ComposeQuadrant()
        MyForm()
        //Text(text = "Body Content", color = Color(0xFF0F9D58))
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
fun MyForm() {
    val nameValue = rememberSaveable{ mutableStateOf("")}
    val emailValue = rememberSaveable{ mutableStateOf("")}
    val passwordValue = rememberSaveable{ mutableStateOf("") }
    var metric by rememberSaveable { mutableStateOf(true) }
    val metricHeight = rememberSaveable { (mutableStateOf("")) }
    val metricWeight = rememberSaveable { (mutableStateOf("")) }
    val imperialHeight = rememberSaveable { (mutableStateOf("")) }
    val imperialWeight = rememberSaveable { (mutableStateOf("")) }
    var bmiWeight = rememberSaveable { (mutableStateOf(0.0)) }
    var bmiHeight = rememberSaveable { (mutableStateOf(0.0)) }
    var bmi = rememberSaveable { (mutableStateOf(0.0)) }

    Column(verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally){
        Image(
            painterResource("bg_compose_background.png"),
            contentDescription = "Image Description",
        )
        TextField(
            value = nameValue.value,
            onValueChange = { nameValue.value = it},
            textStyle = TextStyle(textAlign = TextAlign.Center),
            label = { Text(text = "Enter your Name")}
        )
        Spacer(modifier = Modifier.height(20.dp).width(20.dp))
        TextField(
            value = emailValue.value,
            onValueChange = { emailValue.value = it},
            textStyle = TextStyle(textAlign = TextAlign.Center),
            label = { Text(text = "Enter your Email")}
        )
        Spacer(modifier = Modifier.height(20.dp).width(20.dp))
        TextField(
            value = passwordValue.value,
            onValueChange = { passwordValue.value = it},
            textStyle = TextStyle(textAlign = TextAlign.Center),
            label = { Text(text = "Enter your Password")}
        )

        Row {
            Button(onClick = { metric = true }) {
                Text(text = "Metric")
                //println(metric)
            }
            Spacer(modifier = Modifier.width(10.dp))
            Button(onClick = { metric = false }) {
                Text(text = "Imperial")
                //println(metric)
            }
        }

        if(metric){
            TextField(
                value = metricHeight.value,
                onValueChange = { metricHeight.value = it},
                textStyle = TextStyle(textAlign = TextAlign.Center),
                label = { Text(text = "Height: centimeters")}
            )
            TextField(
                value = metricWeight.value,
                onValueChange = { metricWeight.value = it},
                textStyle = TextStyle(textAlign = TextAlign.Center),
                label = { Text(text = "Weight: kilograms")}
            )
        }
        else {
            TextField(
                value = metricHeight.value,
                onValueChange = { imperialHeight.value = it},
                textStyle = TextStyle(textAlign = TextAlign.Center),
                label = { Text(text = "Height: Inches")}
            )
            TextField(
                value = metricWeight.value,
                onValueChange = { imperialWeight.value = it},
                textStyle = TextStyle(textAlign = TextAlign.Center),
                label = { Text(text = "Weight: pounds")}
            )
        }

        Button(onClick = {
            bmiWeight.value = metricWeight.value.toDouble()
            bmiHeight.value = metricHeight.value.toDouble() / 100.0
            bmi.value = bmiWeight.value / (bmiHeight.value * bmiHeight.value)
            println(bmi.value.toInt())
        }) {
            Text(text = "Submit")
        }


        Text( text = "Your BMI is ${bmi.value.toInt()}")

    }
}


@OptIn(ExperimentalResourceApi::class)
@Composable
fun NeatScreen() {
    //topBar = { TopAppBar ( title = {Text("My App")} )},

    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))

    val coroutineScope = rememberCoroutineScope()

    Scaffold(

        scaffoldState = scaffoldState,

        topBar = {
            TopBar(

                onMenuClicked = {
                    coroutineScope.launch {
                        scaffoldState.drawerState.open()
                    }
                })
        },

        bottomBar = { BottomBar() },

        content = {
            Body()
        },

        drawerContent = {
            Drawer()
        },

//        floatingActionButton = {
//            // Create a floating action button in
//            // floatingActionButton parameter of scaffold
//            FloatingActionButton(
//
//                onClick = {
//                    // When clicked open Snackbar
//                    coroutineScope.launch {
//                        when (scaffoldState.snackbarHostState.showSnackbar(
//                            // Message In the snackbar
//                            message = "Snack Bar",
//                            actionLabel = "Dismiss"
//                        )) {
//                            SnackbarResult.Dismissed -> {
//                                // do something when
//                                // snack bar is dismissed
//                            }
//
//                            SnackbarResult.ActionPerformed -> {
//                                // when it appears
//                            }
//                        }
//                    }
//                }) {
//                // Simple Text inside FAB
//                Text(text = "X")
//            }
//        }
    )
}

@OptIn(ExperimentalResourceApi::class)
@Composable
fun App() {

    AppTheme {

        NeatScreen()
        //Banner("Justin")
    }



    //Banner("Justin")
    //ComposeArticle()
    //TaskManager()
    //ComposeQuadrant()
//    MaterialTheme {
//        val sum = {a:Int, b:Int -> a+b}
//        var greetingText by remember { mutableStateOf(greeting("Justin", "20")) }
//        var showImage by remember { mutableStateOf(false) }
//        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
//            Button(onClick = {
//                greetingText = "Hello, ${getPlatformName()}"
//                showImage = !showImage
//
//                var sum = myFunction(1,2)
//                println(sum)
//                val lambdaSum = sum(1,2)
//                println(lambdaSum)
//            }) {
//                Text(greetingText)
//            }
//            AnimatedVisibility(showImage) {
//                Image(
//                    painterResource("compose-multiplatform.xml"),
//                    null
//                )
//            }
//        }
//    }
}

expect fun getPlatformName(): String