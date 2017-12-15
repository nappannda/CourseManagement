package develop.nappa.coursemanagement.activity

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import develop.nappa.coursemanagement.R
import develop.nappa.coursemanagement.databinding.ContentCourseListBinding
import develop.nappa.coursemanagement.model.Course
import develop.nappa.coursemanagement.view.CourseListAdapter
import io.realm.Realm
import io.realm.RealmResults
import kotlinx.android.synthetic.main.activity_course_list.*

class CourseListActivity : AppCompatActivity() {

    private var realm: Realm? = null
    private var courseList = mutableListOf<Course>()
    private var listAdapter: CourseListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course_list)
        setSupportActionBar(toolbar)

        val binding : ContentCourseListBinding = DataBindingUtil.setContentView(this, R.layout.content_course_list)
        listAdapter = CourseListAdapter(this)

        realm = Realm.getDefaultInstance()
        reloadCourseList()

        binding.courseListView.adapter = listAdapter
        binding.setOnItemClick { adapterView, view, position, l ->

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        realm?.close()
    }

    private fun reloadCourseList() {
        courseList.clear()
        val _realm = realm
        if (_realm != null) {
            val result: RealmResults<Course> =  _realm.where(Course::class.java).findAll()
            for (course in result) {
                courseList.add(course)
            }
        }
        listAdapter?.courses = courseList
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_course_list, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
