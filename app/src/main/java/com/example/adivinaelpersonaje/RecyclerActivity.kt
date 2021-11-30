package com.example.adivinaelpersonaje

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerActivity: AppCompatActivity() {

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null
    private var recyclerView: RecyclerView = findViewById(R.id.recyclerView)

    override fun onCreate(savedInstanceState: Bundle?){
       super.onCreate(savedInstanceState)
       setContentView(R.layout.historial_layout)

        layoutManager = LinearLayoutManager(this)

        recyclerView.layoutManager = layoutManager

        adapter = RecyclerAdapter()
        recyclerView.adapter = adapter
    }
}