import androidx.compose.runtime.mutableStateOf

object CRUtilsKT {
    private const val GPA_CRITERIA = 8.5

    fun findQualifyingStudents(students: ArrayList<Student>): ArrayList<QualifyingStudent> {
        val qualifyingStudent = arrayListOf<QualifyingStudent>()
        students.forEach {
            if (it.GPA >= GPA_CRITERIA) {
                qualifyingStudent.add(QualifyingStudent(it, mutableStateOf("0")))
            }
        }
        return qualifyingStudent
    }

    fun findCR(students: ArrayList<QualifyingStudent>): QualifyingStudent? {
        val max = students.maxByOrNull {
            it.votes.value.toInt()
        }
        return max
    }
}