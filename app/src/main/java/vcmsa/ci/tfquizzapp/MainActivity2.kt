package vcmsa.ci.tfquizzapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

        //User interface
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val rbTrue = findViewById<RadioButton>(R.id.rbTrue)
        val rbFalse = findViewById<RadioButton>(R.id.rbFalse)
        val nextButton = findViewById<Button>(R.id.btnNxt)
        val finishButton = findViewById<Button>(R.id.btnFinish)
        val txtResult = findViewById<TextView>(R.id.txtResult)

        //Questions for the user
        val questions = arrayOf(
            "The sun is a star", "Jupiter is a small planet", "Pluto is a dwarf planet",
            "Venus is 3 in the solar system", "We live in the Milky Way galaxy"
        )
        //Correct answers
        val answers = arrayOf(
            true, false, true, false, true
        )

        var currentQuestionIndex = 0
        var score = 0
        var selectedAnswer: Boolean? = null

        txtResult.text = questions[currentQuestionIndex]

        rbTrue.setOnClickListener {
            selectedAnswer = true
        }

        rbFalse.setOnClickListener {
            selectedAnswer = false
        }
        //Displays the next question after answering and clicking the button
        nextButton.setOnClickListener {
            if (selectedAnswer == null) {
                Toast.makeText(this, "Select True or False", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (selectedAnswer == answers[currentQuestionIndex]) {
                score++
            }
            if (currentQuestionIndex < questions.size - 1) {
                currentQuestionIndex++
                txtResult.text = questions[currentQuestionIndex]
                radioGroup.clearCheck()
                selectedAnswer = null
            }
            if (currentQuestionIndex == questions.size - 1) {
                finishButton.isEnabled = true
            }
            //After the user answers all the questions click the button to go to the results activity
            finishButton.setOnClickListener {
                if (selectedAnswer == null) {
                    Toast.makeText(this, "Select between True or False", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener

                    if (selectedAnswer == answers[currentQuestionIndex]) {
                        score++
                    }

                }
                val intent = Intent(this, MainActivity3::class.java)
                intent.putExtra("score", score)
                intent.putExtra("totalQuestions", questions.size)
                startActivity(intent)         //Takes the user to the result activity
            }

















































            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
        }
    }
}