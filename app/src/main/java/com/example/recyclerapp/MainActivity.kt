package com.example.recyclerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.fragment.app.Fragment
import com.example.recyclerapp.databinding.ActivityMainBinding
import com.example.recyclerapp.fragment.MainFragment

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragment = MainFragment()
        openFragment(fragment)

    }

    private fun openFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().add(R.id.fr_container, fragment).commit()
    }
}