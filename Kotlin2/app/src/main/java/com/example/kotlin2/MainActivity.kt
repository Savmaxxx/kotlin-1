package com.example.kotlin2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin2.data.Word
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), MyView, OnItemClicked {
    private lateinit var alertDialog: AlertDialog
    private lateinit var myPresenter: MyPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        myPresenter = MyPresenter(this)
        recyclerViewWords.layoutManager = LinearLayoutManager(this)
        myPresenter.loadDB()
        setClickListener()

    }

    override fun updateRecyclerView(list: MutableList<Word>) {
        recyclerViewWords.adapter = AdapterWord(list,this)
    }

    override fun showAlertForAddNewWord() {
        createAlertDialogForAddNewWord()
    }

    override fun showAlertForEditWord(word: Word) {
        createAlertDialogForEditWord(word)
    }

    private fun setClickListener() {
        buttonAddNewWord.setOnClickListener { myPresenter.onButtonAddNewWord() }
    }

    private fun createAlertDialogForAddNewWord() {
        val viewDialogLayout =View.inflate(this,R.layout.alert_dialog_add_new_word, null)
        val buttonSaveWord = viewDialogLayout.findViewById<Button>(R.id.buttonSaveNewWord)
        val editTextWord = viewDialogLayout.findViewById<EditText>(R.id.editTextNewWord)
        buttonSaveWord.setOnClickListener {
            myPresenter.onButtonSaveWord(editTextWord.text.toString().trim())
            alertDialog.dismiss()
        }
        alertDialog = AlertDialog.Builder(this).setView(viewDialogLayout).create()
        alertDialog.show()
    }

    private fun createAlertDialogForEditWord(word: Word) {
        val viewDialogLayout =View.inflate(this,R.layout.alert_dialog_add_new_word, null)
        val buttonSaveWord = viewDialogLayout.findViewById<Button>(R.id.buttonSaveNewWord)
        val editTextWord = viewDialogLayout.findViewById<EditText>(R.id.editTextNewWord)
        val nameAlertDialog=viewDialogLayout.findViewById<TextView>(R.id.nameAlertDialog)
        nameAlertDialog.text="Редактирование"
        editTextWord.setText(word.newWord)
        buttonSaveWord.setOnClickListener {
            word.newWord=editTextWord.text.toString().trim()
            myPresenter.onButtonSaveEditWord(word)
            alertDialog.dismiss()
        }
        alertDialog = AlertDialog.Builder(this).setView(viewDialogLayout).create()
        alertDialog.show()
    }

    override fun onItemClickedRemove(position: Int) {
        myPresenter.onButtonRemoveWord(position)
    }
    override fun onItemClickedEdit(position: Int) {
        myPresenter.onButtonEditWord(position)
    }


}

