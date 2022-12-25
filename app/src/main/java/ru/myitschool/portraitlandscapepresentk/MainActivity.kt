package ru.myitschool.portraitlandscapepresentk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    private val pics = arrayOf(R.drawable.squarecat,
        R.drawable.car1,
        R.drawable.car2,
        R.drawable.car3)
    private var curr_pic = 0
    private lateinit var iv : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        iv = findViewById<ImageView>(R.id.picture)
        curr_pic = savedInstanceState?.getInt("idx") ?: 0
        iv.setImageResource(pics[curr_pic])
    }

    fun onChangePictureClick(v: View) {
        curr_pic = if (curr_pic == 3) 0 else curr_pic + 1
        iv.setImageResource(pics[curr_pic])
        Log.d("CURR_PIC", curr_pic.toString())
    }

    override fun onSaveInstanceState(saveInstanceState: Bundle) {
        saveInstanceState.putInt("idx", curr_pic)
        super.onSaveInstanceState(saveInstanceState)
    }
}