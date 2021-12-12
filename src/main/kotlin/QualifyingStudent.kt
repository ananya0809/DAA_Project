import androidx.compose.runtime.MutableState

data class QualifyingStudent(
    val student: Student,
    val votes: MutableState<String>
)