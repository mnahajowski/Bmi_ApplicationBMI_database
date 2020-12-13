package pl.pwr.andz1.i00000.bmi

import pl.pwr.andz1.i00000.Database.BmiResultObject
import java.io.Serializable

const val MAXIMUM_LIST_SIZE = 10
class BmiHistory  (
        private var last10List: ArrayList<BmiResultObject> = arrayListOf()
) : Serializable{

    fun add(bmiObject : BmiResultObject) {
        if(last10List.size > MAXIMUM_LIST_SIZE - 1)
            last10List = last10List.drop(1) as ArrayList<BmiResultObject>

        last10List.add(bmiObject)
    }

    fun get() : ArrayList<BmiResultObject>{
        return last10List
    }

    fun set(listSave : ArrayList<BmiResultObject>) {
        last10List = listSave
    }
}