package com.example.flavi.championsleague

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText

class NovoPaisActivity : AppCompatActivity() {

    private lateinit var editPaisView: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_novo_pais)
        editPaisView = findViewById(R.id.edit_pais)

        val botao = findViewById<Button>(R.id.botao_salvar)
        botao.setOnClickListener {
            val replyIntent = Intent()
            if (TextUtils.isEmpty(editPaisView.text)) {
                setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {
                val pais = editPaisView.text.toString()
                replyIntent.putExtra(EXTRA_REPLY, replyIntent)
                setResult(Activity.RESULT_OK, replyIntent)
            }
            finish()
        }

    }

    companion object {
        const val EXTRA_REPLY = "com.example.flavi.championsleague.REPLY"
    }
}
