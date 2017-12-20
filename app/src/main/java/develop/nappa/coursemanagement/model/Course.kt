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

    enum class Status(val integerValue: Int) {
        NONE(1), // なし
        DOING(2), // 履修中
        ENROLLED(3), // 履修済み
        RETAKE(4) // 再履修
    }

    private var statusValue: Int = Status.NONE.integerValue
    open var status: Status
        get() = Status.values().first { it.integerValue == statusValue }
        set(value) {
            statusValue = value.integerValue
        }

    fun statusString(): String {
        return when (status) {
            Status.NONE -> "なし"
            Status.DOING -> "履修中"
            Status.ENROLLED -> "履修済み"
            Status.RETAKE -> "再履修"
        }
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
