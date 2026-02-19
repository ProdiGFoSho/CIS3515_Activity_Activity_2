package edu.temple.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContracts
import android.app.Activity

const val Result_Key = "Message"

class DisplayActivity : AppCompatActivity() {

    // TODO Step 1: Launch TextSizeActivity when button clicked to allow selection of text size value

    private lateinit var lyricsDisplayTextView: TextView
    private lateinit var textSizeSelectorButton: Button


    val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        it.data?.run{
            lyricsDisplayTextView.textSize = getIntExtra(Result_Key, 22).toFloat()
        }
    }

    // TODO Step 3: Use returned value for lyricsDisplayTextView text size

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        lyricsDisplayTextView = findViewById(R.id.lyricsDisplayTextView)
        textSizeSelectorButton = findViewById(R.id.textSizeSelectorButton)

        textSizeSelectorButton.setOnClickListener {

            val intent = Intent(this, TextSizeActivity::class.java)

            launcher.launch(intent)
        }

    }
}