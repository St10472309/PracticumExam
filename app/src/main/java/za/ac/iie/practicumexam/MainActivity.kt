package za.ac.iie.practicumexam

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
//Student Number: 10472309
//Student Name: Joshua Zulu
class MainActivity : AppCompatActivity() {
    private val songList = arrayListOf<SongList>()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //Declaration
        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val btnExit = findViewById<Button>(R.id.btnExit)
        val btnViewList = findViewById<Button>(R.id.btnViewList)

        val edtSong = findViewById<EditText>(R.id.edtSong)
        val edtName = findViewById<EditText>(R.id.edtName)
        val edtComments = findViewById<EditText>(R.id.edtComments)
        val edtRating = findViewById<EditText>(R.id. edtRating)

        //Function for the add button
        btnAdd.setOnClickListener {
            val rate = edtRating.text.toString()
            val song = edtSong.text.toString()
            val name = edtName.text.toString()
            val comments = edtComments.text.toString()

            if (song.isEmpty() || name.isEmpty() ||  comments.isEmpty() || rate.isEmpty()) {
                Toast.makeText(this, "Please Enter missing info", Toast.LENGTH_SHORT).show()
            } else {
                try {
                    val rating = rate.toInt()
                    songList.add(SongList(song, name, rating, comments ))
                    Toast.makeText(this, "Item Added", Toast.LENGTH_SHORT).show()
                } catch (e: NumberFormatException) {
                    Toast.makeText(this, "Quantity must be a number", Toast.LENGTH_SHORT).show()
                }
            }
        }

        //Function for the View List Button
        btnViewList.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("songList", songList)
            startActivity(intent)
        }

        //Function for the Exit button
        btnExit.setOnClickListener{
            finish()
        }
    }
}
