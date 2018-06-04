package com.example.luisdelaespriella.firstandroidapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*
import java.util.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        showRandomNumber()
    }

    companion object {
        const val TOTAL_COUNT = "total_count"
    }

    fun showRandomNumber() {
        val count = intent.getIntExtra(SecondActivity.TOTAL_COUNT, 0)
        val random = Random()
        var randomInt = 0
        if (count > 0) {
            // Add 1 because the bound for nextInt is exclusive
            randomInt = random.nextInt(count + 1)
        }

        textview_random.text = Integer.toString(randomInt)
        textview_label.text = getString(R.string.random_heading, count)
    }
}
