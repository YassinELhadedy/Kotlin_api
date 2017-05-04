package retrofitrx.yassinelhadedy.github.com.albumapp.model

import java.io.Serializable

/**
 * Created by Elhadedy on 4/16/2017.
 */

data class Photo(val id:String,
                 val likes:String,
                 val favorites:String,
                 val tags:String,
                 val previewURL:String,
                 val webformatURL:String): Serializable {



}
