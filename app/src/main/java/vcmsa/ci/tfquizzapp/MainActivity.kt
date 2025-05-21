package vcmsa.ci.tfquizzapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // User interface
        val edtInput = findViewById<TextView>(R.id.edtInput)
        val btnShift = findViewById<Button>(R.id.btnShift)

        //When the user click the shift button it starts the next activity
        btnShift.setOnClickListener {
            val message = edtInput.text.toString()
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("message", message)
            startActivity(intent)          //New activity begins


            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
        }

    }
}