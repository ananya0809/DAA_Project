import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

@Composable
@Preview
fun start() {
    MaterialTheme {
        MaterialTheme {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    onClick = {
                        // Launch
                    }
                ) {
                    Text("Start")
                }
            }
        }
    }
}

@Composable
@Preview
fun studentList() {
    MaterialTheme {
        Row (horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxSize().padding(24.dp)) {
            Text("Name")
            Text("Registration No.")
        }
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        studentList()
    }
}
