package retrofitrx.yassinelhadedy.github.com.albumapp.api

import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofitrx.yassinelhadedy.github.com.albumapp.model.PhotoList

/**
 * Created by Elhadedy on 4/16/2017.
 */
class PhotoReciver {
    private val service:PhotoApi
    init {
        val retrofit=Retrofit.Builder()
                .baseUrl("https://pixabay.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        service=retrofit.create(PhotoApi::class.java)

    }
    fun getphotos(callback: Callback<PhotoList>){
        val call=service.getphotos()
        call.enqueue(callback)
    }
}