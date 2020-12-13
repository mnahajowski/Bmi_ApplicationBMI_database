package pl.pwr.andz1.i00000

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import pl.pwr.andz1.i00000.Database.BmiDatabase
import pl.pwr.andz1.i00000.Database.BmiDatabaseDao
import pl.pwr.andz1.i00000.bmi.BmiHistory
import pl.pwr.andz1.i00000.bmi.BmiHistoryViewModel
import pl.pwr.andz1.i00000.bmi.BmiHistoryViewModelFactory
import pl.pwr.andz1.i00000.bmi.HistoryRecyclerAdapter

class HistoryActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    lateinit var viewModel: BmiHistoryViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        val dataSource = BmiDatabase.getInstance(application).bmiDatabaseDao
        val viewModelFactory = BmiHistoryViewModelFactory(dataSource, application)
        viewModel = ViewModelProvider(this, viewModelFactory).get(BmiHistoryViewModel::class.java)


        findViewById<TextView>(R.id.label_result).text = getString(R.string.bmi_text_label)
        findViewById<TextView>(R.id.label_height).text = getString(R.string.height_text_label)
        findViewById<TextView>(R.id.label_mass).text = getString(R.string.mass_text_label)
        findViewById<TextView>(R.id.label_unit).text = getString(R.string.unit_text_label)


        viewModel.results.observe(this, Observer {
            viewManager = LinearLayoutManager(this)
            viewAdapter = HistoryRecyclerAdapter(viewModel.results.value)
            recyclerView = findViewById<RecyclerView>(R.id.myRecyclerView).apply {

                setHasFixedSize(true)
                layoutManager = viewManager
                adapter = viewAdapter

            } })

    }


}