package com.example.luisdelaespriella.firstandroidapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
// This is used to be able to access views without findViewById
// To access all views from a layout file, just import up to the file name and leave out the view name
import kotlinx.android.synthetic.main.activity_main.textView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun popToast(view: View, message: String) {
        val myToast = Toast.makeText(this, message, Toast.LENGTH_SHORT)
        myToast.show()
    }

    fun toastMe(view: View) {
        popToast(view, "Hello from the toaster.")
    }

    fun countMe(view: View) {
        val countString = textView.text.toString()

        var count: Int = Integer.parseInt(countString)
        count++

        textView.text = count.toString()
    }

    fun randomMe(view: View) {
        // Create an Intent to start the second activity
        val randomIntent = Intent(this, SecondActivity::class.java)
        val currentCount = Integer.parseInt(textView.text.toString())

        randomIntent.putExtra(SecondActivity.TOTAL_COUNT, currentCount)

        if (currentCount > 0) {
            // Start the new activity
            startActivity(randomIntent)
        } else {
            popToast(view, "Count needs to be greater than zero!")
        }

    }
}
