package za.ac.iie.practicumexam
//Student Number: 10472309
//Student Name: Joshua Zulu
import java.io.Serializable

data class SongList(
    val Song: String,
    val Name: String,
    val Rating: Int,
    val Comment: String
) : Serializable