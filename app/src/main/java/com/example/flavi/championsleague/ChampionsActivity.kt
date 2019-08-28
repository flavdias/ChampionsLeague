package com.example.flavi.championsleague

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.flavi.domain.Pais
import com.example.flavi.viewmodel.PaisViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ChampionsActivity : AppCompatActivity {

    private lateinit var paisViewModel: PaisViewModel

    companion object {
        const val novoPaisActivityRequestCode = 1
    }

    constructor() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_champions)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        val adapter = PaisAdapter(this)

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        paisViewModel = ViewModelProviders.of(this).get(PaisViewModel::class.java)
        paisViewModel.todosPaises.observe(this, Observer {
            paises -> paises?.let { adapter.setPaises(it) }
        })
        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {
            val intent = Intent(this@ChampionsActivity, NovoPaisActivity::class.java)
            startActivityForResult(intent, novoPaisActivityRequestCode)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == novoPaisActivityRequestCode && resultCode == Activity.RESULT_OK) {
            data?.let {
                val nome = it.getStringExtra(NovoPaisActivity.EXTRA_REPLY)
                val pais = Pais(nome.substring(3).toUpperCase(), nome)
                paisViewModel.insert(pais)
            }
        } else {
            Toast.makeText(applicationContext, R.string.erro_salvar, Toast.LENGTH_LONG).show()
        }
    }
}
