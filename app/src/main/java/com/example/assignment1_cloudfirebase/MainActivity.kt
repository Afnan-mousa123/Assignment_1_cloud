package com.example.assignment1_cloudfirebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    lateinit var name_note: EditText
    lateinit var detailse_note: EditText
    lateinit var num_of_char: EditText
    lateinit var btn_add: Button
    lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = Firebase.firestore
        name_note = findViewById<EditText>(R.id.name_note)
        detailse_note = findViewById<EditText>(R.id.detailse_note)
        num_of_char = findViewById<EditText>(R.id.num_of_char)
        btn_add = findViewById<Button>(R.id.btn_add)


        btn_add.setOnClickListener {
            addToDB(
                name_note.text.toString(),
                detailse_note.text.toString(),
                num_of_char.text.toString().toInt()
            )

            val x = Intent(this,reciclarView::class.java)
            startActivity(x)
        }


    }
    private fun addToDB(name: String, details: String, character: Int) {

        val notes = hashMapOf(
             "name" to name,
             "details" to details,
             "character" to character
        )

        db.collection("note")
            .add(notes)
            .addOnSuccessListener { decumentReference ->
                Log.e("AFN", "Add success with note Id ${decumentReference.id}")
            }
            .addOnFailureListener { exciption ->
                Log.e("AFN", "${exciption.message}")

            }
    }
    }