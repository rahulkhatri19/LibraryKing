package `in`.khatri.rahul.libraryking

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.menu_layout.view.*

class MainActivity : AppCompatActivity() {
    var list: List<String>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        list = listOf("Animation", "Menu 2", "Menu 3")

//        recycleView.adapter = MainPageAdapter(list, this@MainActivity)
    }

    class MainPageAdapter(list: List<String>, context: Context) : BaseAdapter() {

        val menuList: List<String>? = null
        val context: Context? = null

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val menuPosition = menuList!![position]
            val inflater = context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

            val view = inflater.inflate(R.layout.menu_layout, null)

            view.tv_name.text = menuList.get(position)

            return view
        }

        override fun getItem(position: Int): Any {
            return menuList!![position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return menuList?.size!!
        }

    }

}
