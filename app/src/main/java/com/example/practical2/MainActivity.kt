package com.example.practical2

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.practical2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val myName2: MyName = MyName("BAIT")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myName1 = myName2
        binding.doneButton.setOnClickListener { addNickname(it) }
        binding.nicknameText.setOnClickListener { updateNickname(it) }
        // to replace findviewByid with binding
    }

    private fun addNickname(view: View) {

    //binding.nicknameText.text = binding.nicknameEdit.text.toString()
    // toString() can remove the underline of a word
    //binding.nicknameEdit.visibility = View.GONE
    //binding.doneButton.visibility = View.GONE
    //binding.nicknameText.visibility = View.VISIBLE
    // to avoid type many times of binding, we can use binding.apply

    binding.apply {
        myName1?.nickname = binding.nicknameEdit.text.toString()
        invalidateAll()
        // manipulating the view
        // nicknameText.text = binding.nicknameEdit.text.toString() for the user input
        //toString() can remove the underline of a word
        nicknameEdit.visibility = View.GONE
        doneButton.visibility = View.GONE
        nicknameText.visibility = View.VISIBLE
    }
    // Hide the keyboard.
    val inputMethodManager =
        getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun updateNickname(view: View) {
        binding.apply {
            nicknameEdit.visibility = View.VISIBLE
            doneButton.visibility = View.VISIBLE
            nicknameText.visibility = View.GONE
        }
    }
}