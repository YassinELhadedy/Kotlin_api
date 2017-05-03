package retrofitrx.yassinelhadedy.github.com.albumapp

import album2.yassinelhadedy.github.com.albumapp2.R
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import retrofitrx.yassinelhadedy.github.com.albumapp.model.Photo

/**
 * Created by Elhadedy on 4/16/2017.
 */
class MainAdapter(var photos:List<Photo>,
                  var clicklistner:View.OnClickListener): RecyclerView.Adapter<MainAdapter.PhotoViewHolder>() {
    override fun onBindViewHolder(holder: PhotoViewHolder?, position: Int) {
        val photo=photos[position]
        holder?.tags?.text=photo.tags
        holder?.likes?.text=photo.likes
        holder?.fav?.text=photo.favorites.toString()
       if(photo.previewURL.isNotEmpty()){
           Glide.with(holder?.tags?.context).load(photo.previewURL).into(holder?.photo_item)
       }

    }
    fun getphoto(adapterpos:Int):Photo{
    return photos[adapterpos]

}
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): PhotoViewHolder {
        return PhotoViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.photo_item,parent,false))
    }

    override fun getItemCount(): Int {
        return photos.size
    }

    inner class PhotoViewHolder(itemview:View):RecyclerView.ViewHolder(itemview) {
        var tags:TextView
        var likes:TextView
        var fav:TextView
        var photo_item:ImageView
        init {
            if (clicklistner!=null){
                itemview.setOnClickListener(clicklistner)

            }
            itemview.tag=this
            tags=itemview.findViewById(R.id.tags)as TextView
            likes=itemview.findViewById(R.id.likes)as TextView
            fav=itemview.findViewById(R.id.favorites)as TextView
            photo_item=itemview.findViewById(R.id.photo_item)as ImageView


        }

    }
}