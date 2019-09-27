package com.affluencesystems.testthis.ui

//import com.affluencesystems.testthis.databinding.ActivityMainBinding
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.affluencesystems.testthis.R
import com.affluencesystems.testthis.adapters.MainAdapter
import com.affluencesystems.testthis.room.models.User
import com.affluencesystems.testthis.viewmodels.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var recycler: RecyclerView
    //    private lateinit var activtyMainBinding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel
    private var liveData: ArrayList<User> = ArrayList<User>()
    private lateinit var mainAdapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        /*activtyMainBinding = DataBindingUtil.*/setContentView(/*this, */R.layout.activity_main)
//        activtyMainBinding.lifecycleOwner = this
//        activtyMainBinding.executePendingBindings()

        recycler = findViewById(R.id.recycler)
        generaterandomUsers()

        mainViewModel.getAllUsers().observe(this, object : Observer<List<User>> {
            /**
             * Called when the data is changed.
             * @param t  The new data
             */
            override fun onChanged(t: List<User>?) {
                if (t!!.size > 0)
                    mainAdapter.setData(t)
            }
        })
    }

    private fun generaterandomUsers() {
        var nums = 1..30
        for (i in nums) {
            val user: User = User("name$i", "age$i")
            liveData.add(user)
            mainViewModel.setdataToModel(user)
        }
        mainAdapter = MainAdapter(baseContext, MainActivity@ liveData)
        var mgr: RecyclerView.LayoutManager =
            LinearLayoutManager(baseContext, RecyclerView.VERTICAL, false)
        recycler.layoutManager = mgr
        mainAdapter.setData(liveData)
        recycler.adapter = mainAdapter
    }

}
