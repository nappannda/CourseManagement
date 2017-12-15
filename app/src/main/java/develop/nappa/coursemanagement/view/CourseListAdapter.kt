package develop.nappa.coursemanagement.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import develop.nappa.coursemanagement.databinding.ItemCourseListBinding
import develop.nappa.coursemanagement.model.Course

/**
 * Created by nappannda on 2017/12/12.
 */
class CourseListAdapter(private val context: Context) : BaseAdapter() {
    var courses: List<Course> = emptyList()

    override fun getCount(): Int = courses.size

    override fun getItem(position: Int): Any? = courses[position]

    override fun getItemId(position: Int): Long = 0

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val binding: ItemCourseListBinding
        if (convertView == null) {
            binding = ItemCourseListBinding.inflate(LayoutInflater.from(context), parent, false)
            binding.root.tag = binding
        } else {
            binding = convertView.tag as ItemCourseListBinding
        }
        binding?.course = getItem(position) as Course

        return binding.root
    }
}