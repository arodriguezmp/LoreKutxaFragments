package com.example.praktika11fragments.activity

import android.os.Bundle
import android.provider.ContactsContract.Profile
import androidx.appcompat.app.AppCompatActivity
import com.example.praktika11fragments.R
import com.example.praktika11fragments.databinding.ActivityMainBinding
import com.example.praktika11fragments.fragments.HomeFragment
import com.example.praktika11fragments.fragments.ProfileFragment
import com.example.praktika11fragments.fragments.SupportFragment

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction().add(R.id.frameContainer, HomeFragment()).commit()

        binding.bottomNavMenu.setOnItemSelectedListener {
            when(it.itemId){
                R.id.menuHome -> supportFragmentManager.beginTransaction().replace(R.id.frameContainer, HomeFragment()).commit()
                R.id.menuProfile -> supportFragmentManager.beginTransaction().replace(R.id.frameContainer, ProfileFragment()).commit()
                R.id.menuSupport -> supportFragmentManager.beginTransaction().replace(R.id.frameContainer, SupportFragment()).commit()
                R.id.menuExit -> finish()
            }
            true
        }
    }
}