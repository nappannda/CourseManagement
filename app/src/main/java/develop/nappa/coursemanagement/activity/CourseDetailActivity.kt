package develop.nappa.coursemanagement.activity

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import develop.nappa.coursemanagement.R
import develop.nappa.coursemanagement.databinding.ActivityCourseDetailBinding
import develop.nappa.coursemanagement.model.Course
import io.realm.Realm

/**
 * Created by nappannda on 2017/12/22.
 */
class CourseDetailActivity : AppCompatActivity() {

    private var realm: Realm? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        realm = Realm.getDefaultInstance()

        val binding : ActivityCourseDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_course_detail)
        val id = intent.getStringExtra("id")
        val course: Course =  realm!!.where(Course::class.java).contains("id", id).findFirst()
        supportActionBar?.title = course.name
        binding.course = course
    }

    override fun onDestroy() {
        super.onDestroy()
        realm?.close()
    }
}