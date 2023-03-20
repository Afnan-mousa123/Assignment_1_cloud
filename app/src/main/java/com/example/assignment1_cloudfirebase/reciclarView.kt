package com.example.assignment1_cloudfirebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment1_cloudfirebase.Adapter.note_Adapter
import com.example.assignment1_cloudfirebase.Model.Note_Item
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class reciclarView : AppCompatActivity() {
    lateinit var btn_goToAdd:Button
    lateinit var rvNote:RecyclerView
    lateinit var FB:FirebaseFirestore
    lateinit var list:ArrayList<Note_Item>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reciclar_view)
        btn_goToAdd = findViewById(R.id.go_to_add)
        rvNote = findViewById(R.id.recyclerView)
        FB = Firebase.firestore
        list=ArrayList()

        FB.collection("note").get()

            .addOnSuccessListener {
                for (document in it){
                    list.add(
                    Note_Item(
                        document.getString("name")!!,
                        document.getString("details")!!,
                        document.getLong("character")!!.toInt()

                        )
                    )
                    Log.e("Afn","${document.id } => ${document.data}")
                }

                val A = note_Adapter(this, list)
                rvNote.adapter = A
                rvNote.layoutManager = LinearLayoutManager(this)
            }
            .addOnFailureListener {
                Log.e("Afn","Failed get")
            }
        btn_goToAdd.setOnClickListener {
            var i = Intent(this,MainActivity::class.java)
            startActivity(i)
        }
    }
}