package develop.nappa.coursemanagement.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*

/**
 * Created by nappannda on 2017/12/12.
 */
open class Course : RealmObject() {
    @PrimaryKey
    open var id : String = ""
    open var name : String = ""
    open var unit : Int = 0
    open var attendanceCount : Int = 0
    open var memo : String = ""
    open var createdAt : Date = Date()
    open var updatedAt : Date = Date()

    enum class Status(val stringValue: String) {
        NONE("なし"),
        DOING("履修中"),
        ENROLLED("履修済み"),
        RETAKE("再履修");

        open fun statuses() : List<String> {
            var statuses = mutableListOf<String>()
            Status.values().iterator().forEach { status: Status ->
                statuses.add(status.stringValue)
            }
            return statuses.toList()
        }
    }

    private var statusValue: String = Status.NONE.stringValue
    open var status: Status
        get() = Status.values().first { it.stringValue == statusValue }
        set(value) {
            statusValue = value.stringValue
        }

    fun initialize() {
        name = ""
        unit = 0
        attendanceCount = 0
        memo = ""
        createdAt = Date()
        updatedAt = Date()
    }
}
