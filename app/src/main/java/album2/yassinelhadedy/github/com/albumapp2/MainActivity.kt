package album2.yassinelhadedy.github.com.albumapp2

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import retrofit2.Call
import retrofit2.Response
import retrofitrx.yassinelhadedy.github.com.albumapp.MainAdapter
import retrofitrx.yassinelhadedy.github.com.albumapp.api.PhotoReciver
import retrofitrx.yassinelhadedy.github.com.albumapp.model.Photo
import retrofitrx.yassinelhadedy.github.com.albumapp.model.PhotoList

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(view: View?) {
        val intent= Intent(this,Details::class.java)
        val holder =view?.tag as MainAdapter.PhotoViewHolder
        intent.putExtra(Details.PHOTO,mainadapter?.getphoto(holder.adapterPosition))
        startActivity(intent)
    }

    var photos:List<Photo>?=null

    var mainadapter: MainAdapter?=null
    lateinit var recycleview: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        recycleview=findViewById(R.id.recycleview) as RecyclerView
        recycleview.layoutManager= LinearLayoutManager(this)
        val retrieve= PhotoReciver()

        val callback= object : retrofit2.Callback<PhotoList> {
            override fun onFailure(call: Call<PhotoList>?, t: Throwable?) {
                Log.e("main error","problrm",t)
            }

            override fun onResponse(call: Call<PhotoList>?, response: Response<PhotoList>?) {
                response?.isSuccessful.let {
                    this@MainActivity.photos=response?.body()?.hits
                    mainadapter= MainAdapter(this@MainActivity.photos!!,this@MainActivity)
                    recycleview.adapter=mainadapter
                }
            }


        }
        retrieve.getphotos(callback)


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId


        if (id == R.id.action_settings) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }
}
