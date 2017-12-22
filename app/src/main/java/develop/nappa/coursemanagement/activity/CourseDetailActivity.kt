package develop.nappa.coursemanagement.activity

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import develop.nappa.coursemanagement.R
import develop.nappa.coursemanagement.databinding.ActivityCourseDetailBinding

/**
 * Created by nappannda on 2017/12/22.
 */
class CourseDetailActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding : ActivityCourseDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_course_detail)
    }
}