package tech.kapoor.listviewdemo

import android.content.Context
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.main_listview)
        var redColor = Color.parseColor("#FF0000")

        listView.setBackgroundColor(redColor)
        listView.adapter = CustomAdapter(this)
    }

    private class CustomAdapter(context: Context) : BaseAdapter() {

        private val mContext: Context

        init {
            mContext = context
        }

        override fun getCount(): Int {
            return 80
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getItem(position: Int): Any {
            return position
        }

        override fun getView(position: Int, view: View?, viewGroup: ViewGroup?): View {
            val textView = TextView(mContext)
            textView.text = "Here comes the !!"
            return textView
        }
    }
}