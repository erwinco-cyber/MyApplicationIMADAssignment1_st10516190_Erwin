package com.example.myapplicationimadassignment

import android.media.MediaDrm
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity";
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val submitButton = findViewById<Button>(R.id.btnSubmit)
        val resetButton = findViewById<Button>(R.id.btnReset)
        val userInputBox = findViewById<EditText>(R.id.editTextUserInput)
        val messageBox = findViewById<TextView>(R.id.textViewMessage)
        Log.i(TAG, "App started successfully");
        resetButton.setOnClickListener{
            Log.i(TAG, "Reset button clicked");
            messageBox.setTextColor(android.graphics.Color.BLUE);
            messageBox.textSize=25f;
            messageBox.text = "";
            userInputBox.setText("");
        }

        submitButton.setOnClickListener {
            Log.i(TAG, "Submit button clicked");
            messageBox.setTextColor(android.graphics.Color.BLUE);
            messageBox.textSize=25f;

            Log.i(TAG, "The user typed ${userInputBox.text}");

            val userInput = userInputBox.text
                .toString()
                .lowercase()
                .trim()
                .replace(" ","")
                .replace("-","")
            Log.i(TAG, "User input: $userInput");

            if(userInput.contains("afternoonsnacktime"))
            { messageBox.text = "Send a quick 'thinking of you'";}
            else if(userInput.contains("afternoon"))
            { messageBox.text = "Share a funny meme or interesting link with a friend";}
            else if(userInput.contains("midmorning"))
            { messageBox.text = "Reach out to a colleague with a quick 'Thank you'";}
            else if(userInput.startsWith("morning"))
            { messageBox.text = "Send a 'Good morning' text to a family member";}
            else if(userInput.contains("afterdinner"))
            { messageBox.text = "Leave a thoughtful comment on a freind's post"}
            else if(userInput.contains("dinner"))
            { messageBox.text = "Call a friend or relative for a 5-minute catch-up";}

            else {
                messageBox.setTextColor(android.graphics.Color.RED);
                messageBox.textSize=24f;
                messageBox.text = "You did not enter a valid option, please try again";
                Log.i(TAG, "Could not find a valid option");
            }
        }
    }
}
