package vcmsa.ci.tfquizzapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity3 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main3)

        //User Interface
        val score = intent.getIntExtra("score", 0)
        val totalQuestions = intent.getIntExtra("totalQuestions", 0)

        val resultText = findViewById<TextView>(R.id.resultTxt)
        val exitButton = findViewById<Button>(R.id.btnExit)

        //Results of the user displayed with message depending how they did
        var message = "Your score: $score out of $totalQuestions"

        message += if (score == totalQuestions) {
            "\n  Congratulations! You got everything correct you genius!"
        }else if (score >= totalQuestions * 0.7) {
            "\n Well done! You can do better next time"
        }else if (score >= totalQuestions * 0.5) {
            "\n Nice try do better next time!"
        }else {
            "\n Try again!"
        }

        resultText.text = message

        //Exits the app immediately
        exitButton.setOnClickListener {
            finishAffinity()
        }























        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}