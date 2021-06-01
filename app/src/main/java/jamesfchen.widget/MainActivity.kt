package com.hawksjamesf.collapsetextview

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.markzhai.recyclerview.SingleTypeAdapter
import com.google.android.material.snackbar.Snackbar
import com.hawksjamesf.collapsetextview.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    val list = arrayListOf(
            "hello world\nhello world\nhello world\nhello world\nhello world\nhello world\nhello world\nhello world\n",
            "hello world\nhello world\nhello world\nhello world\nhello world\nhello world\nhello world\nhello world\n",
            "hello world\nhello world\nhello world\nhello world\nhello world\nhello world\nhello world\nhello world\n",
            "hello world\nhello world\nhello world\nhello world\nhello world\nhello world\nhello world\nhello world\n",
            "hello world\nhello world\nhello world\nhello world\nhello world\nhello world\nhello world\nhello world\n",
            "hello world\nhello world\nhello world\nhello world\nhello world\nhello world\nhello world\nhello world\n",
            "hello world\nhello world\nhello world\nhello world\nhello world\nhello world\nhello world\nhello world\n",
            "hello world\nhello world\nhello world\nhello world\nhello world\nhello world\nhello world\nhello world\n",
            "hello world\nhello world\nhello world\nhello world\nhello world\nhello world\nhello world\nhello world\n",
            "hello world\nhello world\nhello world\nhello world\nhello world\nhello world\nhello world\nhello world\n",
            "hello world\nhello world\nhello world\nhello world\nhello world\nhello world\nhello world\nhello world\n",
            "hello world\nhello world\nhello world\nhello world\nhello world\nhello world\nhello world\nhello world\n",
            "hello world\nhello world\nhello world\nhello world\nhello world\nhello world\nhello world\nhello world\n",
            "hello world\nhello world\nhello world\nhello world\nhello world\nhello world\nhello world\nhello world\n",
            "hello world\nhello world\nhello world\nhello world\nhello world\nhello world\nhello world\nhello world\n",
            "hello world\nhello world\nhello world\nhello world\nhello world\nhello world\nhello world\nhello world\n",
            "hello world\nhello world\nhello world\nhello world\nhello world\nhello world\nhello world\nhello world\n")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val databinding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        val singleTypeAdapter = SingleTypeAdapter<String>(this, R.layout.item_content)
        rv.adapter = singleTypeAdapter
        val lm = LinearLayoutManager(this)
        rv.layoutManager = lm
        rv.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))
        singleTypeAdapter.addAll(list)
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
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
