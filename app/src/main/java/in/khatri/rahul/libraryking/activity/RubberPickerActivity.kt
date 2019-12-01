package `in`.khatri.rahul.libraryking.activity

import `in`.khatri.rahul.libraryking.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jem.rubberpicker.RubberRangePicker
import com.jem.rubberpicker.RubberSeekBar
import kotlinx.android.synthetic.main.activity_rubber_picker.*

class RubberPickerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rubber_picker)

        val rubberSeekbar = findViewById<RubberSeekBar>(R.id.rubberSeekBar)
        val rubberRangePicker = findViewById<RubberRangePicker>(R.id.rubberRangePicker)

        val currentSeekValue = rubberSeekbar.getCurrentValue()
        val currentStartRangeValue = rubberRangePicker.getCurrentStartValue()
        val currentEndRangeValue = rubberRangePicker.getCurrentEndValue()

        btn_range.setOnClickListener {
        tv_range.text = "SeekBar Value : ${rubberSeekbar.getCurrentValue()}\nRange Start : ${rubberRangePicker.getCurrentStartValue()}  -  Range End : ${rubberRangePicker.getCurrentEndValue()}"
        }

        rubberSeekbar.setOnRubberSeekBarChangeListener(object : RubberSeekBar.OnRubberSeekBarChangeListener{
            override fun onProgressChanged(seekBar: RubberSeekBar, value: Int, fromUser: Boolean) {
tv_seekBar.text = "Rubber Seek Range is : $value"
            }

            override fun onStartTrackingTouch(seekBar: RubberSeekBar) {

            }

            override fun onStopTrackingTouch(seekBar: RubberSeekBar) {

            }

        })

        rubberRangePicker.setOnRubberRangePickerChangeListener(object : RubberRangePicker.OnRubberRangePickerChangeListener{
            override fun onProgressChanged(
                rangePicker: RubberRangePicker,
                startValue: Int,
                endValue: Int,
                fromUser: Boolean
            ) {
                tv_rangeBar.text = "Rubber Range Bar is \nStart : $startValue  -  End : $endValue"
            }

            override fun onStartTrackingTouch(
                rangePicker: RubberRangePicker,
                isStartThumb: Boolean
            ) {

            }

            override fun onStopTrackingTouch(
                rangePicker: RubberRangePicker,
                isStartThumb: Boolean
            ) {

            }

        })
    }
}
