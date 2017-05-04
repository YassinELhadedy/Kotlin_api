package retrofitrx.yassinelhadedy.github.com.albumapp.api

import retrofit2.Call
import retrofit2.http.GET
import retrofitrx.yassinelhadedy.github.com.albumapp.model.PhotoList

/**
 * Created by Elhadedy on 4/16/2017.
 */
interface PhotoApi {
    @GET("?key=5117661-135672936918d7a7f4cb98cc6&q=nature&image_type=photo")
    fun getphotos(): Call<PhotoList>
}