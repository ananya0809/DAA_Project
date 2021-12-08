import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

/***
 * Main Start Screen
 */
@Composable
@Preview
fun Start() {
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
                        currentState.value++
                    }
                ) {
                    Text("Start")
                }
            }
        }
    }
}

// Sample Student list, will be renamed in future
val sampleStudents = mutableStateListOf<Student>()

/***
 * Total Student List Screen
 */
@Composable
@Preview
fun TotalStudentList() {
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
                    sampleStudents.add(Student("Added", "Sample", "ABc", "123", "123", "!23", 9.1, false))
                }) {
                    Text("+ Add")
                }
                Button(onClick = {
                    // Go to next Screen
                    currentState.value++
                }) {
                    Text("Next")
                }
            }
        }
    }
}

// Qualifying Students [Sublist of Total Students]
private lateinit var qualifyingStudents: ArrayList<QualifyingStudent>

@Composable
@Preview
fun QualifyingStudentList() {
    // find qualifying students
    val sampleStudentsAL = sampleStudents.mapTo(arrayListOf()) {
        it
    }
    qualifyingStudents = CRUtilsKT.findQualifyingStudents(sampleStudentsAL)

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
                    currentState.value++
                }) {
                    Text("Next")
                }
            }
        }
    }
}

@Composable
@Preview
fun AskVotes() {
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
                    Row {
                        Text(text = std.student.name, modifier = Modifier.padding(horizontal = 24.dp))
                        Text(text = std.student.regNum, modifier = Modifier.padding(horizontal = 24.dp))
                        TextField(
                            // TODO : Replace index of with something more robus
                            value = std.votes.value.toString(),
                            onValueChange = {
                                std.votes.value = it.toInt()
                            },
                            label = {
                                Text("Number of Votes")
                            }
                        )
                    }
                }
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxSize().padding(24.dp),
            ) {
                Button(onClick = {
                    // Go to next Screen
                    currentState.value++
                }) {
                    Text("Next")
                }
            }
        }
    }
}

@Composable
fun ShowResult(result: ArrayList<QualifyingStudent>) {
    MaterialTheme {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LazyColumn {
                item {
                    Text("Result :")
                }
                items(result) { std ->
                    Text(std.student.name)
                }
            }
        }
    }
}

var currentState = mutableStateOf(0)
fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        when(currentState.value) {
            0 -> Start()
            1 -> TotalStudentList()
            2 -> QualifyingStudentList()
            3 -> AskVotes()
            4 -> ShowResult(qualifyingStudents)
            else -> {
                println("No more screens left!")
            }
        }
    }
}