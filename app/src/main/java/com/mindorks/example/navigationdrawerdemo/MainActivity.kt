package com.mindorks.example.navigationdrawerdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.core.view.GravityCompat
import com.mindorks.example.navigationdrawerdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews(){
        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.baseline_home_24)
        }
        binding.navView.setNavigationItemSelectedListener {menuIteims ->
            menuIteims.isChecked = true
            when(menuIteims.itemId){
                R.id.home -> showToast(getString(R.string.home))
                R.id.message -> showToast(getString(R.string.message))
                R.id.synch -> showToast(getString(R.string.synch))
                R.id.trash -> showToast(getString(R.string.trash))

                R.id.settings -> showToast(getString(R.string.settings))
                R.id.logout -> showToast(getString(R.string.logout))
                R.id.share -> showToast(getString(R.string.share))
                R.id.rateus -> showToast(getString(R.string.rate_us))
            }
            true
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == android.R.id.home){
            showToast("Hello")
            if(binding.drawerLayout.isDrawerOpen(GravityCompat.START)){
                   binding.drawerLayout.closeDrawer(GravityCompat.START)
            }else{
                binding.drawerLayout.openDrawer(GravityCompat.START)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}