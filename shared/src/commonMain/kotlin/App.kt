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
//import androidx.compose.foundation.layout.RowScopeInstance.weight
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFrom
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Button
import androidx.compose.material.DrawerValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import ui.theme.AppTheme
import ui.theme.ThemeShapes
import kotlin.math.absoluteValue

/*
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

 */

/**     -----      START OF ASSIGNMENT       -----        */

/**    My GitHub Repo: https://github.com/ken2615/composeMultiplatform    **/

/**
 * This is the top bar that shows the name of the Page and
 * clickable Navigation Icon.
 **/
@Composable
fun TopBar(onMenuClicked: () -> Unit) {
    TopAppBar(
        title = {
            Text(text = "Sign Up", color = Color.White)
        },
        navigationIcon = {
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = "Menu",

                modifier = Modifier.clickable (onClick = onMenuClicked),
                tint = Color.White
            )
        },
        backgroundColor = Color(0xFFF6977A)
    )
}

/**
 * This is the bottom bar of the Scaffolding. Here we show
 * the different sections of the App like the Home Page,
 * User Page, Shopping Page and Settings.
 **/
@Composable
fun BottomBar() {

    BottomAppBar(
        backgroundColor = Color(0xFFF6977A)//f6977a

    ) {
        //Text(text = "Bottom App Bar", color = Color.White)
        Spacer(Modifier.weight(0.5f))
        Icon(Icons.Filled.Home, contentDescription = "Home Page")
        Spacer(Modifier.weight(1f))
        Icon(Icons.Filled.Person, contentDescription = "User Page")
        Spacer(Modifier.weight(1f))
        Icon(Icons.Filled.ShoppingCart, contentDescription = "Shopping Page")
        Spacer(Modifier.weight(1f))
        Icon(Icons.Filled.Settings, contentDescription = "Settings Page")
        Spacer(Modifier.weight(0.5f))

    }
}

/***
 * This is where the contents for the drawer goes when the user
 * click the navigation icon in the Top Bar. Here we will show
 * links for various exercises on a specific region of the body.
 */
@Composable
fun Drawer() {
    Column(
        Modifier
            .background(Color.White)
            .fillMaxSize()
    ) {
        Text(text = "Chest Exercise", modifier = Modifier.padding(8.dp), color = Color.Black)
        Text(text = "Cardio Exercise", modifier = Modifier.padding(8.dp), color = Color.Black)
        Text(text = "Legs Exercise", modifier = Modifier.padding(8.dp), color = Color.Black)
        Text(text = "Back Exercise", modifier = Modifier.padding(8.dp), color = Color.Black)
        Text(text = "Shoulder Exercise", modifier = Modifier.padding(8.dp), color = Color.Black)
    }
}

/**
 * This is the body of the scaffold where we show the logo of the app
 * and the Signup Form.
 **/
@Composable
fun Body() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        MyForm()
    }
}
/**
 * This is a signup form that gets the user's name, email, password,
 * weight and height. It has an option for the user to choose between
 * Metric and Imperial measurements. When the user filled-up all the
 * required fields, the Submit button will appear. If the Submit button
 * is pressed, it will calculate the user's BMI.
 **/
@OptIn(ExperimentalResourceApi::class)
@Composable
fun MyForm() {
    val nameValue = rememberSaveable{ mutableStateOf("")}
    val emailValue = rememberSaveable{ mutableStateOf("")}
    val passwordValue = rememberSaveable{ mutableStateOf("") }
    var metric by rememberSaveable { mutableStateOf(true) }
    val showText = rememberSaveable {(mutableStateOf(false))}
    val metricHeight = rememberSaveable { (mutableStateOf("")) }
    val metricWeight = rememberSaveable { (mutableStateOf("")) }
    val imperialFoot = rememberSaveable { (mutableStateOf("")) }
    val imperialInch = rememberSaveable { (mutableStateOf("")) }
    val imperialWeight = rememberSaveable { (mutableStateOf("")) }
    var bmiWeight = rememberSaveable { (mutableStateOf(0.0)) }
    var bmiHeight = rememberSaveable { (mutableStateOf(0.0)) }
    var bmi = rememberSaveable { (mutableStateOf(0.0)) }

    Column(verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize().padding(start = 10.dp, end = 10.dp)
    ){
        Image(
            painterResource("Exercise.jpg"),
            contentDescription = "Image Description",
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth().clip(ThemeShapes.small),
            value = nameValue.value,
            onValueChange = { nameValue.value = it},
            textStyle = TextStyle(textAlign = TextAlign.Start),
            label = { Text(text = "Enter your Name")},
            leadingIcon = {Icon(Icons.Filled.Person, contentDescription = "Name")}
        )
        Spacer(modifier = Modifier.height(20.dp).width(20.dp))
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth().clip(ThemeShapes.small),
            value = emailValue.value,
            onValueChange = { emailValue.value = it},
            textStyle = TextStyle(textAlign = TextAlign.Start),
            label = { Text(text = "Enter your Email")},
            leadingIcon = { Icon(Icons.Filled.Email, contentDescription = "Email")}
        )
        Spacer(modifier = Modifier.height(20.dp).width(20.dp))
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth().clip(ThemeShapes.small),
            value = passwordValue.value,
            onValueChange = { passwordValue.value = it},
            textStyle = TextStyle(textAlign = TextAlign.Start),
            label = { Text(text = "Enter your Password")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = PasswordVisualTransformation(),
            leadingIcon = { Icon(Icons.Filled.Lock, contentDescription = "Password")}
        )

        Row {
            OutlinedButton(onClick = {
                metric = true
                showText.value = false}) {
                Text(text = "Metric")
                //println(metric)
            }
            Spacer(modifier = Modifier.width(10.dp))
            OutlinedButton(onClick = {
                metric = false
                showText.value = false}) {
                Text(text = "Imperial")
                //println(metric)
            }
        }

        if(metric){
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth().clip(ThemeShapes.small),
                value = metricHeight.value,
                onValueChange = { metricHeight.value = it},
                textStyle = TextStyle(textAlign = TextAlign.Center),
                label = { Text(text = "Height: centimeters")}
            )
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth().clip(ThemeShapes.small),
                value = metricWeight.value,
                onValueChange = { metricWeight.value = it},
                textStyle = TextStyle(textAlign = TextAlign.Center),
                label = { Text(text = "Weight: kilograms")}
            )
        }
        else {
            Row (
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
                    ){
                OutlinedTextField(
                    modifier = Modifier.weight(1f).clip(ThemeShapes.small),
                    value = imperialFoot.value,
                    onValueChange = { imperialFoot.value = it},
                    textStyle = TextStyle(textAlign = TextAlign.Center),
                    label = { Text(text = "Foot")}
                )
                Spacer(modifier = Modifier.width(10.dp))
                OutlinedTextField(
                    modifier = Modifier.weight(1f).clip(ThemeShapes.small),
                    value = imperialInch.value,
                    onValueChange = { imperialInch.value = it},
                    textStyle = TextStyle(textAlign = TextAlign.Center),
                    label = { Text(text = "Inch")}
                )
            }
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth().clip(ThemeShapes.small),
                value = imperialWeight.value,
                onValueChange = { imperialWeight.value = it},
                textStyle = TextStyle(textAlign = TextAlign.Center),
                label = { Text(text = "Weight: pounds")}
            )
        }

        if(nameValue.value.isNotEmpty() && emailValue.value.isNotEmpty() && passwordValue.value.isNotEmpty()){
            if(metric && metricHeight.value.isNotEmpty() && metricWeight.value.isNotEmpty()){
                Button(onClick = {
                    bmiWeight.value = metricWeight.value.toDouble()
                    bmiHeight.value = metricHeight.value.toDouble() / 100.0
                    bmi.value = bmiWeight.value / (bmiHeight.value * bmiHeight.value)
                    showText.value = true
                }) {
                    Text(text = "Submit")
                }
            }
            else if(!metric && imperialFoot.value.isNotEmpty() && imperialInch.value.isNotEmpty() && imperialWeight.value.isNotEmpty()){
                Button(onClick = {
                    bmiHeight.value = ((imperialFoot.value.toDouble() * 12) + imperialInch.value.toDouble()) / 39.37
                    bmiWeight.value = imperialWeight.value.toDouble() / 2.205
                    bmi.value = bmiWeight.value / (bmiHeight.value * bmiHeight.value)
                    showText.value = true
                }) {
                    Text(text = "Submit")

                }
            }
            if(showText.value){
                Text( text = "Your BMI is ${bmi.value.toInt()}")
                CheckBMI(bmi.value.toInt())
            }
        }
    }
}

/**
 * Base on the calculated BMI, this function will classify
 * the user's BMI and give the recommended exercises.
 *
 * */
@Composable
fun CheckBMI(bmi: Int ) {
    if(bmi >= 40){
        Text( text = "base on your BMI you are Severe Obese, these our recommended exercises for you", textAlign = TextAlign.Justify)
    }
    else if(bmi in 35..39) {
        Text( text = "base on your BMI you are Moderate Obese, these our recommended exercises for you", textAlign = TextAlign.Justify)
    }
    else if(bmi in 30 .. 34) {
        Text( text = "base on your BMI you are Mild Obese, these our recommended exercises for you", textAlign = TextAlign.Justify)
    }
    else if(bmi in 25 .. 29){
        Text( text = "base on your BMI you are Overweight, these our recommended exercises for you", textAlign = TextAlign.Justify)
    }
    else if(bmi in 18 .. 24){
        Text( text = "base on your BMI you have Normal Weight, these our recommended exercises for you", textAlign = TextAlign.Justify)
    }
    else if (bmi < 18){
        Text( text = "base on your BMI you are Under weight, these our recommended exercises for you", textAlign = TextAlign.Justify)
    }
}

/**
 * This is the function that creates the Scaffold Composable. The scaffold
 * contains the TopBar, BottomBar, Body and the Drawer.
 * The drawer is inspired from: https://www.geeksforgeeks.org/scaffold-in-android-using-jetpack-compose/
 */

@OptIn(ExperimentalResourceApi::class)
@Composable
fun NeatScreen() {

    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed)) //initial value of scaffold is that Drawer is close

    val coroutineScope = rememberCoroutineScope() // this is like AsyncTask where the task is executed at the background instead of the main thread

    Scaffold(

        scaffoldState = scaffoldState,

        topBar = {
            TopBar(
                onMenuClicked = {
                    coroutineScope.launch {
                        scaffoldState.drawerState.open()        //open the Drawer when the navigation icon is clicked
                    }
                })
        },

        bottomBar = { BottomBar() },

        content = {
            Body()
        },

        drawerContent = {
            Drawer()
        }
    )
}

@OptIn(ExperimentalResourceApi::class)
@Composable
fun App() {

    AppTheme {
        NeatScreen()
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