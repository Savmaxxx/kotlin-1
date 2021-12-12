package com.example.kotlin2

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.kotlin2.data.Word
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.alert_dialog_add_new_word.*
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity(), MyView, CoroutineScope {
    private lateinit var alertDialog: AlertDialog
    private lateinit var myPresenter: MyPresenter
    private var job: Job = Job()

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO + job

    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }

    @SuppressLint("InflateParams")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setClickListener()
        myPresenter = MyPresenter(this)
        alertDialog = AlertDialog.Builder(this)
            .setView(layoutInflater.inflate(R.layout.alert_dialog_add_new_word, null))
            .create()
recyclerViewWords.adapter

    }

    override fun updateRecyclerView(list: MutableList<Word>) {

    }


    override fun showAlertForAddNewWord() {
        createAlertDialogForAddNewWord()

    }


    private fun setClickListener() {
        buttonAddNewWord.setOnClickListener { myPresenter.onButtonAddNewWord() }
    }


    @SuppressLint("InflateParams")
    fun createAlertDialogForAddNewWord() {
        buttonSaveNewWord.setOnClickListener {
            launch { myPresenter.onButtonSaveWord(editTextNewWord.text.toString().trim())  }
            alertDialog.dismiss()
        }
        alertDialog.show()


    }


}