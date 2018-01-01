package develop.nappa.coursemanagement.activity

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import develop.nappa.coursemanagement.R
import develop.nappa.coursemanagement.databinding.ActivityCourseDetailBinding
import develop.nappa.coursemanagement.model.Course
import io.realm.Realm

/**
 * Created by nappannda on 2017/12/22.
 */
class CourseDetailActivity : AppCompatActivity() {

    private lateinit var realm: Realm
    private lateinit var binding: ActivityCourseDetailBinding

    private var course: Course? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        realm = Realm.getDefaultInstance()

        binding = DataBindingUtil.setContentView(this, R.layout.activity_course_detail)
        binding.courseDetail = this

        val id = intent.getStringExtra("id")
        course =  realm.where(Course::class.java).contains("id", id).findFirst()
        supportActionBar?.title = course?.name
        binding.course = course
    }

    override fun onDestroy() {
        super.onDestroy()
        realm.close()
    }

    fun courseNameTextChanged(text: CharSequence) {
        realm.beginTransaction()
        course?.name = text.toString()
        realm.commitTransaction()
    }

    fun unitTextChanged(text: CharSequence) {
        var unit = 0
        try {
            unit = text.toString().toInt()
        }
        catch (e: NumberFormatException) {
            Toast.makeText(this, "数字を入力してください", Toast.LENGTH_SHORT).show()
            binding.unitEditText.setText("0")
        }
        realm.beginTransaction()
        course?.unit = unit
        realm.commitTransaction()
    }

    fun memoTextChanged(text: CharSequence) {
        realm.beginTransaction()
        course?.memo = text.toString()
        realm.commitTransaction()
    }

    fun plusAttendance() {
        realm.beginTransaction()
        course!!.attendanceCount = course!!.attendanceCount.inc()
        realm.commitTransaction()
        binding.attendanceCountNumberText.setText(course!!.attendanceCount.toString())
    }

    fun minusAttendance() {
        if (course!!.attendanceCount == 0) {
            Toast.makeText(this, "出席数を0未満に設定することは出来ません", Toast.LENGTH_SHORT).show()
            return
        }
        realm.beginTransaction()
        course!!.attendanceCount = course!!.attendanceCount.dec()
        realm.commitTransaction()
        binding.attendanceCountNumberText.setText(course!!.attendanceCount.toString())
    }
}