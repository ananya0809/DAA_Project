import androidx.compose.runtime.mutableStateOf

object CRUtilsKT {
    private const val GPA_CRITERIA = 8.5

    fun findQualifyingStudents(students: ArrayList<Student>): ArrayList<QualifyingStudent> {
        val qualifyingStudent = arrayListOf<QualifyingStudent>()
        for (i in 0 until students.size) {
            val temp = students.get(i)
            if (temp.GPA >= GPA_CRITERIA) {
                qualifyingStudent.add(QualifyingStudent(temp, mutableStateOf("0")))
            }
        }
        return qualifyingStudent
    }

    fun findCR(students: ArrayList<QualifyingStudent>): QualifyingStudent? {
        var maxValue = -1
        var maxStudent = students.get(0)
        for (i in 0 until students.size) {
            val temp = students.get(i)
            if (temp.votes.value.toInt() > maxValue) {
                maxValue = temp.votes.value.toInt()
                maxStudent = temp
            }
        }
        return maxStudent
    }
}