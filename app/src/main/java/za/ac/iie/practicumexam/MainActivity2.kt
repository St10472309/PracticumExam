package za.ac.iie.practicumexam

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
//Student Number: 10472309
//Student Name: Joshua Zulu
class MainActivity2 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

        val listView = findViewById<ListView>(R.id.listView)
        val returnButton = findViewById<Button>(R.id.returnButton)
        val AvgBtn = findViewById<Button>(R.id.AvgBtn)


        val sList = intent.getSerializableExtra("songList") as? ArrayList<SongList> ?: arrayListOf()


        val filteredItems = sList.filter { it.Rating >= 2 }
            .map { "The song title:${it.Song} , The artist's name:${it.Name} , The rating:${it.Rating}, User comments:${it.Comment} " }

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, filteredItems)
        listView.adapter = adapter

        returnButton.setOnClickListener {
            finish()
        }
    }
}