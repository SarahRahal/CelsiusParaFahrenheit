package com.example.celsiusparafahrenheit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.celsiusparafahrenheit.ui.theme.CelsiusParaFahrenheitTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CelsiusParaFahrenheitTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun MyApp(){

    var entrada = remember {
        mutableStateOf("")
    }

    var saida = remember {
        mutableDoubleStateOf(0.00)
    }

    Column (
        modifier = Modifier
            .padding(5.dp)

    ){

        Text(
            text = "Temperatura em Celsius",
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
        )

        OutlinedTextField(
            value = entrada.value,
            onValueChange = { entrada.value = it},
            modifier = Modifier
                .fillMaxWidth()
                .padding(32.dp)
        )

        Button(
            onClick = {
                saida.value = ((entrada.value.toDouble()*1.8)+32)
            },
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(text = "CALCULAR")
        }

        Text(
            text = " Graus fahrenheit = ${saida.value} ºF",
            fontSize = 30.sp,
        )

    }

}

