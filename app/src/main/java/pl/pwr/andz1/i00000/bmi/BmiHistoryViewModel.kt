package pl.pwr.andz1.i00000.bmi

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import pl.pwr.andz1.i00000.Database.BmiDatabaseDao
import pl.pwr.andz1.i00000.Database.BmiResultObject

class BmiHistoryViewModel(val database: BmiDatabaseDao,
                          application: Application
) : AndroidViewModel(application){
    var results: MutableLiveData<List<BmiResultObject>> = MutableLiveData()

    init {
        viewModelScope.launch {
            results.value = database.getAllResults()
        }
    }

    private suspend fun insert(bmiResult: BmiResultObject) {
        database.insert(bmiResult)
    }

    private suspend fun update(bmiResult: BmiResultObject) {
        database.update(bmiResult)
    }

    private suspend fun clear() {
        database.clear()
    }


    fun insertValue(bmiResult : BmiResultObject) {
        viewModelScope.launch {
            insert(bmiResult)
        }
    }
}