package develop.nappa.coursemanagement.application

import android.app.Application
import io.realm.Realm

/**
 * Created by nappannda on 2017/12/12.
 */

class CourseManagementApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
    }
}