package tech.kapoor.listviewdemo

import android.content.Context
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.main_listview)
        listView.adapter = CustomAdapter(this)
    }

    private class CustomAdapter(context: Context) : BaseAdapter() {

        private val mContext: Context
        private val names = arrayListOf<String>(
                "Ashish0","Ashish1","Ashish2","Ashish3","Ashish4"
        )

        init {
            mContext = context
        }

        override fun getCount(): Int {
            return names.size
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getItem(position: Int): Any {
            return position
        }

        override fun getView(position: Int, view: View?, viewGroup: ViewGroup?): View {
            val layoutInflater = LayoutInflater.from(mContext)
            val rowMain = layoutInflater.inflate(R.layout.row_main, viewGroup, false)
            val nameTextView = rowMain.findViewById<TextView>(R.id.name_textView)
            val positionTextView = rowMain.findViewById<TextView>(R.id.position_textView)
            positionTextView.text = "This is the row number...$position"
            nameTextView.text = names[position]
            return rowMain
        }
    }
}