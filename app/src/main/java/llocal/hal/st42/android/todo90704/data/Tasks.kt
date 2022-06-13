package llocal.hal.st42.android.todo90704.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Tasks(
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    var name: String,

    var deadline: Int,

    var done: Int,

    var note: String

)
