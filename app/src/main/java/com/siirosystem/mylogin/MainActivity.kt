package com.siirosystem.mylogin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.createSavedStateHandle
import com.siirosystem.mylogin.InputType.Name.keyboardOptions
import com.siirosystem.mylogin.R.drawable.siiro_logo
import com.siirosystem.mylogin.ui.theme.MyLoginTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyLoginTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Login()
                }
            }
        }
    }
}
@Composable
fun Login(){
    Column (
        Modifier
            .padding(24.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp, alignment = Alignment.Bottom),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Icon(painter = painterResource(id = siiro_logo),
            contentDescription =null,
            Modifier.size(100.dp),
            tint = Color.DarkGray
            )
        TextInput(InputType.Name)
        TextInput(InputType.Pass)
        Button(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth()) {
            Text("Iniciar sesión",Modifier.padding(vertical=8.dp))
        }
        Divider(
            color=Color.White.copy(alpha = .3f),
            thickness = 1.dp,
            modifier = Modifier.padding(top=48.dp)
        )
        Row(verticalAlignment = Alignment.CenterVertically){
            Text(text = "¿no tiene una cuenta Siiro?", color = Color.Gray)
            TextButton(onClick = {}) {
                Text(text = "REGISTRARME")
            }
        }
    }

}

sealed class InputType(
    val label:String,
    val icon: ImageVector,
    val keyboardOptions: KeyboardOptions,
    val visualTransformation: VisualTransformation
){
    object Name: InputType(
        label="Username",
        icon= Icons.Default.Person,
        keyboardOptions=KeyboardOptions(imeAction=ImeAction.Next),
        visualTransformation= VisualTransformation.None
    )
    object Pass: InputType(
        label="Pass",
        icon= Icons.Default.Lock,
        keyboardOptions=KeyboardOptions(imeAction=ImeAction.Next, keyboardType = KeyboardType.Password),
        visualTransformation= VisualTransformation.None
    )
}
@Composable
fun TextInput(inputType: InputType) {
    var value:String by remember {
        mutableStateOf("")
    }
    TextField(
        value = value,
        onValueChange = {value=it},
        modifier = Modifier.fillMaxWidth(),
        leadingIcon = {Icon(imageVector = inputType.icon, contentDescription = null)},
        label = { Text(text = inputType.label)},
        shape= MaterialTheme.shapes.small,
        colors = TextFieldDefaults(
            back
        )




    )
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyLoginTheme {
        Greeting("Android")
    }
}