package `in`.khatri.rahul.libraryking

import `in`.khatri.rahul.libraryking.activity.RubberPickerActivity
import `in`.khatri.rahul.libraryking.model.MainPageModel
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexboxLayout
import com.google.android.flexbox.FlexboxLayoutManager
import com.google.android.flexbox.JustifyContent
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.menu_layout.view.*

class MainActivity : AppCompatActivity() {
    var list: MutableList<MainPageModel>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        list = listOf("Animation", "Rubber Picker", "Menu 3")
        list = mutableListOf()
        list?.add(MainPageModel("Animation", "", 1))
        list?.add(MainPageModel("Rubber Picker", "", 2))
        list?.add(MainPageModel("Menu 3", "", 3))
        Log.e("list main", "$list")
        val flexBoxLayout = FlexboxLayoutManager(this)
        flexBoxLayout.flexDirection = FlexDirection.ROW
        flexBoxLayout.justifyContent = JustifyContent.SPACE_EVENLY
        recycleView.layoutManager = flexBoxLayout
        recycleView.adapter = MenuAdapter(this, list!!)
    }

    class MenuAdapter(val context: Context, val listMenu: MutableList<MainPageModel>) :
        RecyclerView.Adapter<MenuAdapter.ViewHolder>() {

        class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val tvName = view.tv_name
            val tvImage = view.iv_logo
            val clLayout = view.constraintLayout
        }

        override fun getItemCount(): Int {
            return listMenu.size
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder(
                LayoutInflater.from(context).inflate(
                    R.layout.menu_layout,
                    parent,
                    false
                )
            )
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val listItem = listMenu.get(position)
            holder.tvName.text = listItem.name
            holder.clLayout.setOnClickListener {
                when (position) {
                    1 -> context.startActivity(Intent(context, RubberPickerActivity::class.java))
                }
            }
        }
    }
}
