package pl.pwr.andz1.i00000.bmi


import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import pl.pwr.andz1.i00000.Database.BmiDatabaseDao

class BmiHistoryViewModelFactory(
        private val dataSource: BmiDatabaseDao,
        private val application: Application) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BmiHistoryViewModel::class.java)) {
            return BmiHistoryViewModel(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
