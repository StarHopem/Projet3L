package com.example.projet


import android.content.res.Configuration
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import androidx.fragment.app.Fragment
import com.example.projet.databinding.ActivityMainBinding
import java.util.*
import android.view.View



@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(Home())

        supportFragmentManager.beginTransaction().replace(R.id.frame_layout,Home()).commit()

        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home -> replaceFragment(Home())
                R.id.profile -> replaceFragment(Profile())
                R.id.favorites -> replaceFragment(FavoritesFragment())
                R.id.settings -> replaceFragment(Settings())
                else ->{
                }
            }
            true
        }

        //for the language
        /*val res1: Resources = this.resources
        val dm1: DisplayMetrics = res1.displayMetrics
        val conf1: Configuration = res1.configuration
        conf1.setLocale(Locale("en"))
        res1.updateConfiguration(conf1, dm1)*/

        // Hide the navigation bar
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION




    }

    private fun replaceFragment(fragment : Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()
    }

}
