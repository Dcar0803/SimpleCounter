package com.example.simplecounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import android.widget.TextView
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        var count = 0
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        val textView = findViewById<TextView>(R.id.textView)

        button.setOnClickListener {
            Toast.makeText(it.context, "Clicked button", Toast.LENGTH_SHORT).show()
            count++
            textView.text = count.toString()

            if (count >= 100) {
                // Show upgrade button and set onClickListener
                val upgradeButton = findViewById<Button>(R.id.upgradeBtn)
                upgradeButton.visibility = View.VISIBLE
                upgradeButton.setOnClickListener {
                    button.text = "Add 2"

                    // Update original button to add 2 instead of 1
                    button.setOnClickListener {
                        count += 2
                        textView.text = count.toString()
                    }

                    // Hide upgrade button again
                    upgradeButton.visibility = View.INVISIBLE
                }
            }
        }
    }
}
