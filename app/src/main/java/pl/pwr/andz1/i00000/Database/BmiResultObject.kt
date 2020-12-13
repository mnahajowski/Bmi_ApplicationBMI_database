package pl.pwr.andz1.i00000.Database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
import java.util.*
@Entity(tableName = "bmi_result_table")
class BmiResultObject (
        @PrimaryKey(autoGenerate = true)
        var bmi_id: Long = 0L,

        @ColumnInfo(name = "bmi_result")
        var bmi_result : Double,

        @ColumnInfo(name = "height")
        var height : Int,

        @ColumnInfo(name = "weight")
        var weight : Int,

        @ColumnInfo(name = "unit_type")
        var unit : String,

        @ColumnInfo(name = "date")
        var date: Long = System.currentTimeMillis()

) : Serializable