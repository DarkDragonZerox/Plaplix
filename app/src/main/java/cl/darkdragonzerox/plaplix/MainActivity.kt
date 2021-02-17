package cl.darkdragonzerox.plaplix

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cl.darkdragonzerox.plaplix.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.beginTransaction().replace(R.id.main_container,ListFragment()).addToBackStack("back").commit()
    }
}