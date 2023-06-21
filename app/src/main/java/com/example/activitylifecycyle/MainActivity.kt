package com.example.activitylifecycyle

import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.databinding.DataBindingUtil
import com.example.activitylifecycyle.databinding.ActivityMainBinding
import com.example.activitylifecycyle.ui.theme.ActivityLifecycyleTheme


class MainActivity : ComponentActivity() {
    private lateinit var binding: ActivityMainBinding
    private val TOTAL_VALUE = "totalValue"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

            binding.textTotal.text = savedInstanceState?.getString(TOTAL_VALUE) ?: "0"


        Log.i("MainActivity","onCreate() called. ${binding.textTotal.text.toString()}")
        binding.btnAdd.setOnClickListener{
            if(binding.textTotal.text.isEmpty()) binding.textTotal.text = "0"
            binding.textTotal.text = (binding.textTotal.text.toString().toInt() + 5).toString()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString(TOTAL_VALUE, binding.textTotal.text.toString())
        Log.i("MainActivity","onSaveInstanceState() called.")
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.i("MainActivity","onRestoreInstanceState() called.")
    }
    override fun onRestart() {
        super.onRestart()
        Log.i("MainActivity","onRestart() called.")
    }

    override fun onStart() {
        super.onStart()
        Log.i("MainActivity","onStart() called.")
    }

    override fun onResume() {
        super.onResume()
        Log.i("MainActivity","onResume() called.")
    }

    override fun onPause() {
        super.onPause()
        Log.i("MainActivity","onPause() called.")
    }

    override fun onStop() {
        super.onStop()
        Log.i("MainActivity","onStop() called.")
    }


    override fun onDestroy() {
        super.onDestroy()
        Log.i("MainActivity","onDestroy() called.")
    }

}

