package develop.nappa.coursemanagement.view

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import develop.nappa.coursemanagement.databinding.ItemCourseListBinding
import develop.nappa.coursemanagement.model.Course

/**
 * Created by nappannda on 2017/12/12.
 */
class CourseRecyclerViewAdapter(private var courses: List<Course>, val clickListener: (Course) -> Unit) : RecyclerView.Adapter<CourseRecyclerViewAdapter.CourseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        val binding = ItemCourseListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CourseViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        val course = courses[position]
        holder.setUp(course)
        holder.itemView.setOnClickListener { clickListener(course) }
    }

    override fun getItemCount(): Int {
        return this.courses.count()
    }
    
    class CourseViewHolder(private val binding: ItemCourseListBinding): RecyclerView.ViewHolder(binding.root) {
        fun setUp(course: Course) {
            binding.course = course
            binding.executePendingBindings()
        }
    }
}