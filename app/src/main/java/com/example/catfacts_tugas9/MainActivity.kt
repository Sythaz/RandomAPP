package com.example.catfacts_tugas9

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.catfacts_tugas9.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ApiConfig.getApiService().getCat().enqueue(object : Callback<ResponseCat> {
            override fun onResponse(
                call: Call<ResponseCat>,
                response: Response<ResponseCat>
            ) {
                if (response.isSuccessful) {
                    val responseCat = response.body()
                    //Ambil data yang ingin ditampilkan dari responseCat yaitu "data" List<Dataitem?>?
                    val dataCat = responseCat?.data
                    val catAdapter = CatAdapter(dataCat)
                    binding.itemJoke.apply {
                        layoutManager = LinearLayoutManager(this@MainActivity)
                        setHasFixedSize(true)
                        catAdapter.notifyDataSetChanged()
                        adapter = catAdapter
                    }
                }
            }
            override fun onFailure(call: Call<ResponseCat>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message}")
            }
        })
    }
}