package com.example.consumiendo_api.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.example.consumiendo_api.data.model.Characters
import com.example.consumiendo_api.data.model.Result
import com.example.consumiendo_api.data.network.RetrofitInstance
import com.example.consumiendo_api.databinding.ActivityMainBinding
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var response: Response<Characters>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val apiService = RetrofitInstance.retrofitService
        lifecycleScope.launchWhenStarted {
            response = apiService.getAllCharacters("character")
            if(response.isSuccessful){
                if (response.body()!=null){
                    val personaje = response.body()!!.results[16]
                    setUI(personaje)
                }
            }
        }
    }

    private fun setUI(personaje: Result) {
        Glide.with(this@MainActivity)
            .load(personaje.image)
            .centerCrop()
            .into(binding.ivCharacter)
        binding.tvNameCharacter.text = personaje.name
        binding.tvGenderCharacter.text = personaje.gender
        binding.tvSpecieCharacter.text = personaje.species
        binding.tvStateCharacter.text = personaje.status
    }
}