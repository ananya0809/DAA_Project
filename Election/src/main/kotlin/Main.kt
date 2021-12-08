import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
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

val sampleStudents = mutableStateListOf<Student>()
@Composable
@Preview
fun studentList() {
    sampleStudents.add(Student("Name 1", "1222"))
    sampleStudents.add(Student("Name 2", "1222"))
    sampleStudents.add(Student("Name 3", "1222"))
    MaterialTheme {
        // TODO : Figure out a way to make Add button position constant and independent
        Column {
            LazyColumn {
                item {
                    // TODO : Fix spacing between titles and items
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxSize().padding(24.dp)
                    ) {
                        Text(text = "Name", style = MaterialTheme.typography.h5)
                        Text(text = "Registration No.", style = MaterialTheme.typography.h5)
                    }
                }
                items(items = sampleStudents) { std ->
                    Row(modifier = Modifier.fillMaxSize()) {
                        Text(text = std.name, modifier = Modifier.padding(horizontal = 24.dp))
                        Text(text = std.regNum, modifier = Modifier.padding(horizontal = 24.dp))
                    }
                }
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxSize().padding(24.dp),
            ) {
                Button(onClick = {
                    sampleStudents.add(Student("Added", "Sample"))
                }) {
                    Text("+ Add")
                }
                Button(onClick = {
                    // Go to next Screen
                }) {
                    Text("Next")
                }
            }
        }
    }
}

val qualifyingStudents = mutableStateListOf<QualifyingStudent>()
@Composable
@Preview
fun findQualifyingStudent() {
    sampleStudents.forEach { student ->
        // Perform this in a separate function and apply qualifying logic
        qualifyingStudents.add(QualifyingStudent(student, 0))
    }
    MaterialTheme {
        // TODO : Figure out a way to make Add button position constant and independent
        Column {
            LazyColumn {
                item {
                    // TODO : Fix spacing between titles and items
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxSize().padding(24.dp)
                    ) {
                        Text(text = "Name", style = MaterialTheme.typography.h5)
                        Text(text = "Registration No.", style = MaterialTheme.typography.h5)
                    }
                }
                items(items = qualifyingStudents) { std ->
                    Row(modifier = Modifier.fillMaxSize()) {
                        Text(text = std.student.name, modifier = Modifier.padding(horizontal = 24.dp))
                        Text(text = std.student.regNum, modifier = Modifier.padding(horizontal = 24.dp))
                    }
                }
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxSize().padding(24.dp),
            ) {
                Button(onClick = {
                    // Go to next Screen
                }) {
                    Text("Next")
                }
            }
        }
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        findQualifyingStudent()
    }
}