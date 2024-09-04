package com.example.android.entiendeviewmodel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.android.entiendeviewmodel.ui.theme.EntendiendoViewModelTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EntendiendoViewModelTheme {
                MyScaffold()
            }
        }
    }
}

class AppViewModel: ViewModel() {
    var acceso by mutableStateOf(false)
        private set

    fun cambiarAcceso() {
        acceso = !acceso
    }

}

@Composable
fun MyScaffold(
    modifier: Modifier = Modifier,
    appViewModel: AppViewModel = viewModel(),
) {
    Scaffold(
        topBar = { TopBarApp(mostrar = appViewModel.acceso) }
    ) { innerPadding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Hola Mundo!",
                fontSize = 24.sp
            )
            Button(
                onClick = { appViewModel.cambiarAcceso() }
            ) {
                Text(text = "Mostrar menú")
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarApp(
    mostrar: Boolean
) {
    TopAppBar(
        title = {
            Text(text = "Barra Superior")
        },
        navigationIcon = {
            IconButton(
                onClick = {}
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = null
                )
            }
        },
        actions = {
            if (mostrar) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = null,
                    modifier = Modifier.padding(end = 16.dp)
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        )
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MyScaffoldPreview() {
    MyScaffold()
}